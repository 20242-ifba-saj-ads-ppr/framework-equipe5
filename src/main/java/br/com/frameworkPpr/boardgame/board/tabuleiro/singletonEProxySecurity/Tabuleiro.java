package main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.br.com.frameworkPpr.boardgame.board.Casa;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.game.gamerules.GerenciadorVitoriaDerrota.Observer;
import main.java.br.com.frameworkPpr.boardgame.game.gamerules.GerenciadorVitoriaDerrota.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.boardgame.game.gamerules.GerenciadorVitoriaDerrota.VitoriaException;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;
import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;

/**
 * A classe Tabuleiro é um exemplo da aplicação do padrão de projeto Singleton. 
 * Ele é aplicado para instanciar o jogo de tabuleiro.
 * Isso garante que haja apenas uma instância do jogo de tabuleiro em toda a aplicação.
 * Nessa casse terá apenas a lógica de negócio do tabuleiro, ou seja, o que pode ser feito no tabuleiro.
 */
public class Tabuleiro {
    private Map<Posicao, Casa> casas;
    private Map<Time, Integer> pecasPorTime;
    private VitoriaDerrotaObserver vitoriaDerrotaObserver;
    private static Tabuleiro instance;
    // Instancia do TabuleiroProxySecurity(Singleton) para validações de jogo
    private static TabuleiroProxySecurity proxySecurityInstance;
    private List<Observer> observadores = new ArrayList<>();


    // Construtor privado
    private Tabuleiro() {
        setProxySecurityInstance(TabuleiroProxySecurity.getInstance());
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        setVitoriaDerrotaObserver(new VitoriaDerrotaObserver(this));
    }

    // Método Principal de instanciamento do tabuleiro via Singleton
    public static Tabuleiro getInstance() {
        synchronized (Tabuleiro.class){
            if (instance == null) {
                instance = new Tabuleiro();
            }
        }
        return instance;
    }
    // Nesse metodo é passado as linhas e colunas do tabuleiro
    public void inicializarCasas (int linhas, int colunas){
        getProxySecurityInstance().inicializarCasas(linhas, colunas);// Algumas validações
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                getCasas().put(posicao, new Casa(posicao));
            }
        }
    }

    public void registrarTime(String nomeTime) {
        Time time = Time.getInstance(nomeTime);
        pecasPorTime.putIfAbsent(time, 0);
    }

    // Esse metodo é chamado para colocar uma peça no tabuleiro
    // Ele tambem realiza verificações via proxy
    public void colocarPeca(Peca peca, Posicao posicao) {
        getProxySecurityInstance().colocarPeca(peca, posicao, getCasas());// A proxy
        getCasas().get(posicao).setPeca(peca);
        getPecasPorTime()
            .put(getCasas()
            .get(posicao).getPeca().getTime(), 
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao)
            .getPeca().getTime(), 0) + 1); // Incrementa o número de peças do time
            adicionarObservador(peca);
            notificarObservadores("Peça adicionada na posição: " + posicao);
    }
    
    // Esse metodo é chamado para mover uma peça no tabuleiro
    // Ele tambem realiza verificações via proxy
    public void moverPeca(Posicao origem, Posicao destino) {
        getProxySecurityInstance().moverPeca(origem, destino, getCasas());

        Casa casaDestino = getCasas().get(destino);
        getProxySecurityInstance().moverPeca(origem, destino, getCasas());
        
        Casa casaOrigem = getCasas().get(origem);
        Peca pecaMovida = casaOrigem.getPeca();
        casaDestino.setPeca(pecaMovida);
        casaOrigem.setPeca(null);

        notificarObservadores("peca movida: " + origem + " para " + destino);

        getCasas().get(destino).setPeca(getCasas().get(origem).getPeca());
        getCasas().get(origem).setPeca(null);
    }

    // Esse metodo é chamado para remover uma peça do tabuleiro
    public void RemoverPeca(Posicao posicao) throws VitoriaException{
        getProxySecurityInstance().removerPeca(posicao);// Verificação do proxy
        if(getVitoriaDerrotaObserver().verificarVencedor() != null){
           throw new VitoriaException("O jogo já acabou, não é possível remover peças. Ja temos um vencedor: " + getVitoriaDerrotaObserver().verificarVencedor().toString());
        }
        getPecasPorTime()
            .put(getCasas().get(posicao).getPeca().getTime(),// pego o time com base na peça que estiver na casa
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao).getPeca().getTime(), 0) - 1); // Decrementa o número de peças do time com base no que estiver na casa
        getCasas()
            .get(posicao)
            .setPeca(null);// Depois limpa a peca que estiver na casa
    }
    public void iniciarJogo (){// Metodo de iniciar o jogo 
        getProxySecurityInstance().setJogoIniciado(true);
    }

    public void finalizarJogo (){// Metodo de finalizar o jogo
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

    // Metodos de Acesso 
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
