package main.java.br.com.frameworkPpr.boardgame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.memento.TabuleiroMemento;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.Observer;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.exceptions.VitoriaException;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.TimeMultiton;
import main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.proxy.TabuleiroProxySecurity;

public class Tabuleiro {
    private Map<Posicao, Casa> casas;
    private Map<TimeMultiton, Integer> pecasPorTime;//@Nathy-Brito não sei se vai ser mais util 
    private VitoriaDerrotaObserver vitoriaDerrotaObserver;
    private static TabuleiroProxySecurity proxySecurityInstance;
    private List<Observer> observadores = new ArrayList<>();

    public Tabuleiro() {
        setProxySecurityInstance(TabuleiroProxySecurity.getInstance());
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        setVitoriaDerrotaObserver(new VitoriaDerrotaObserver(this));
    }

    public void inicializarCasas (int linhas, int colunas){
        getProxySecurityInstance().inicializarCasas(linhas, colunas);
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                getCasas().put(posicao, new Casa(posicao));
            }
        }
    }

    public void registrarTime(String nomeTime) {
        TimeMultiton time = TimeMultiton.getInstance(nomeTime);// @Nathy-Brito Aqui tu ja ta registrando o time 
        pecasPorTime.putIfAbsent(time, 0);// @Nathy-Brito como isso ja é do multiton quando registrado,
        // não sei se é mais necessario 
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        getProxySecurityInstance().colocarPeca(peca, posicao, getCasas());
        getCasas().get(posicao).setPeca(peca);
        TimeMultiton.getInstance(peca.getTime().toString()).adicionarPecasAoTime(peca);
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
        notificarObservadores("peça movida: " + origem.getLinha() + "," + origem.getColuna() + " para " + destino.getLinha() + "," + destino.getColuna());
    }

    public void removerPeca(Posicao posicao) throws VitoriaException {
        getProxySecurityInstance().removerPeca(posicao);
        if(getVitoriaDerrotaObserver().verificarVencedor() != null){
           throw new VitoriaException("O jogo já acabou, não é possível remover peças. Já temos um vencedor: " + getVitoriaDerrotaObserver().verificarVencedor().toString());
        }
        TimeMultiton.getInstance(// Recuperar a instancia do time 
                getCasas()// Na casa
                .get(posicao)// Da Posição 
                .getPeca()// Pega a peça
                .getTime()// Dessa peça eu pego o time
                .toString()) // Mas como é string, pego a string
            .removerPecaDoTime(// Chamo o metodo RemoverPecaDoTime do mutiton
                getCasas()// Na casa
                .get(posicao)// Da Posição
                .getPeca());// Pega a peça isso por si só ja remove a peça do time e decrementa a quantidade de peças
        getCasas()
            .get(posicao)
            .setPeca(null);
    }

    public void iniciarJogo (){
        getProxySecurityInstance().iniciarJogo();
    }

    public void finalizarJogo (){
        getProxySecurityInstance().finalizarJogo();
    }

    public void desistir(TimeMultiton timeDesistente) throws VitoriaException{
        if (getVitoriaDerrotaObserver().verificarVencedor() != null) {
            throw new VitoriaException("O jogo já acabou, não é possível desistir.");
        }
        TimeMultiton vencedor = getPecasPorTime().keySet().stream()
        .filter(time -> !Objects.equals(time,timeDesistente))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Nenhum time restante para declarar como vencedor."));
        System.out.println("O time " + vencedor.toString() + " venceu por desistência do time " + timeDesistente.toString());
        getVitoriaDerrotaObserver().notificarVencedor(vencedor);
        finalizarJogo();
    }

    public Map<TimeMultiton, Integer> getPecasPorTime() {
        return pecasPorTime;
    }

    private Map<Posicao, Casa> getCasas() {
        return casas;
    }

    private void setPecasPorTime(Map<TimeMultiton, Integer> pecasPorTime) {
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

    public TabuleiroMemento criarMemento()
    {
        return new TabuleiroMemento(new HashMap<>(casas), new HashMap<>(pecasPorTime));
    }

    public void restaurarMemento(TabuleiroMemento memento)
    {
        setCasas(new HashMap<>(memento.getCasasSnapshot()));
        setPecasPorTime(new HashMap<>(memento.getPecasPorTimeSnapshot()));
    }
}