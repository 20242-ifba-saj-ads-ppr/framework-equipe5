package main.java.br.com.frameworkPpr.boardgame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.Observer;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.exceptions.VitoriaException;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.factory.Peca;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;
import main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.proxy.TabuleiroProxySecurity;

public class Tabuleiro {
    private Map<Posicao, Casa> casas;
    private Map<Time, Integer> pecasPorTime;
    private VitoriaDerrotaObserver vitoriaDerrotaObserver;
    private static Tabuleiro instance;
    private static TabuleiroProxySecurity proxySecurityInstance;
    private List<Observer> observadores = new ArrayList<>();

    private Tabuleiro() {
        setProxySecurityInstance(TabuleiroProxySecurity.getInstance());
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        setVitoriaDerrotaObserver(new VitoriaDerrotaObserver(this));
    }

    public static Tabuleiro getInstance() {
        synchronized (Tabuleiro.class){
            if (instance == null) {
                instance = new Tabuleiro();
            }
        }
        return instance;
    }

    public void inicializarCasas (int linhas, int colunas){
        getProxySecurityInstance().inicializarCasas(linhas, colunas);
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; colunas < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                getCasas().put(posicao, new Casa(posicao));
            }
        }
    }

    public void registrarTime(String nomeTime) {
        Time time = Time.getInstance(nomeTime);
        pecasPorTime.putIfAbsent(time, 0);
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        getProxySecurityInstance().colocarPeca(peca, posicao, getCasas());
        getCasas().get(posicao).setPeca(peca);
        getPecasPorTime()
            .put(getCasas()
            .get(posicao).getPeca().getTime(), 
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao)
            .getPeca().getTime(), 0) + 1);
        adicionarObservador(peca);
        notificarObservadores("Peça adicionada na posição: " + posicao);
    }
    
    public void moverPeca(Posicao origem, Posicao destino) {
        getProxySecurityInstance().moverPeca(origem, destino, getCasas());
        Casa casaDestino = getCasas().get(destino);
        Casa casaOrigem = getCasas().get(origem);
        Peca pecaMovida = casaOrigem.getPeca();
        casaDestino.setPeca(pecaMovida);
        casaOrigem.setPeca(null);
        notificarObservadores("peça movida: " + origem + " para " + destino);
    }

    public void removerPeca(Posicao posicao) throws VitoriaException {
        getProxySecurityInstance().removerPeca(posicao);
        if(getVitoriaDerrotaObserver().verificarVencedor() != null){
           throw new VitoriaException("O jogo já acabou, não é possível remover peças. Já temos um vencedor: " + getVitoriaDerrotaObserver().verificarVencedor().toString());
        }
        getPecasPorTime()
            .put(getCasas().get(posicao).getPeca().getTime(),
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao).getPeca().getTime(), 0) - 1);
        getCasas()
            .get(posicao)
            .setPeca(null);
    }

    public void iniciarJogo (){
        getProxySecurityInstance().setJogoIniciado(true);
    }

    public void finalizarJogo (){
        getProxySecurityInstance().setJogoIniciado(false);
    }

    public void desistir(Time timeDesistente) throws VitoriaException{
        if (getVitoriaDerrotaObserver().verificarVencedor() != null) {
            throw new VitoriaException("O jogo já acabou, não é possível desistir.");
        }
        Time vencedor = getPecasPorTime().keySet().stream()
        .filter(time -> !time.equals(timeDesistente))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Nenhum time restante para declarar como vencedor."));
        System.out.println("O time " + vencedor.toString() + " venceu por desistência do time " + timeDesistente.toString());
        getVitoriaDerrotaObserver().notificarVencedor(vencedor);
        finalizarJogo();
    }

    public Map<Time, Integer> getPecasPorTime() {
        return pecasPorTime;
    }

    private Map<Posicao, Casa> getCasas() {
        return casas;
    }

    private void setPecasPorTime(Map<Time, Integer> pecasPorTime) {
        this.pecasPorTime = pecasPorTime;
    }
    private void setCasas(Map<Posicao, Casa> casas) {
        this.casas = casas;
    }

    public VitoriaDerrotaObserver getVitoriaDerrotaObserver() {
        return vitoriaDerrotaObserver;
    }

    private void setVitoriaDerrotaObserver(VitoriaDerrotaObserver vitoriaDerrotaObserver) {
        this.vitoriaDerrotaObserver = vitoriaDerrotaObserver;
    }

    public static TabuleiroProxySecurity getProxySecurityInstance() {
        return proxySecurityInstance;
    }

    public static void setProxySecurityInstance(TabuleiroProxySecurity proxyInstance) {
        Tabuleiro.proxySecurityInstance = proxyInstance;
    }

    public void adicionarObservador(Observer observador)
    {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador)
    {
        observadores.remove(observador);
    }

    public void notificarObservadores(String evento)
    {
        for (Observer observador : observadores)
        {
            observador.update(evento);
        }
    }
}