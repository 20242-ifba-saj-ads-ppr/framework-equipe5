package main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import main.java.br.com.frameworkPpr.boardgame.board.Casa;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
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

    // Construtor privado
    private Tabuleiro() {
        setProxySecurityInstance(TabuleiroProxySecurity.getInstance());
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        getPecasPorTime().put(Time.BRANCO, 0);
        getPecasPorTime().put(Time.PRETO, 0);
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
    }
    
    // Esse metodo é chamado para mover uma peça no tabuleiro
    // Ele tambem realiza verificações via proxy
    public void moverPeca(Posicao origem, Posicao destino) {
        getProxySecurityInstance().moverPeca(origem, destino, getCasas());
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
        Time vencedor = (Objects.equals(timeDesistente, Time.BRANCO)) ? Time.PRETO : Time.BRANCO;
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
}
