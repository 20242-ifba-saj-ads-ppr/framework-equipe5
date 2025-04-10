package main.java.br.com.frameworkPpr.xadrez.board;
import java.util.HashMap;
import java.util.Map;
import main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota.VitoriaException;
import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;
import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

/**
 * A classe FrameworkJogoDetabuleiro é um exemplo da aplicação 
 * do padrão de projeto Singleton. Ele é aplicado para estanciar o jogo de tabuleiro.
 * Isso garante que haja apenas uma instância do jogo de tabuleiro em toda a aplicação.
 */
public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Map<Posicao, Casa> casas;
    private Map<Time, Integer> pecasPorTime;
    private VitoriaDerrotaObserver vitoriaDerrotaObserver;
    private static Tabuleiro instance;

    private Tabuleiro() {
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        getPecasPorTime().put(Time.BRANCO, 0);
        getPecasPorTime().put(Time.PRETO, 0);
        setVitoriaDerrotaObserver(new VitoriaDerrotaObserver(this));
    }

    public static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }
        return instance;
    }

    public void inicializarCasas (int linhas, int colunas){
        if (getLinhas() == 0 && getColunas() == 0) {
            setLinhas(linhas);
            setColunas(colunas);
        } else {
            throw new IllegalArgumentException("O tabuleiro já foi inicializado. Não é possível redefinir o tamanho.");
        }
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                getCasas().put(posicao, new Casa(posicao));
            }
        }
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (getCasas().get(posicao) == null) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
        if (getCasas().get(posicao).estaOcupada()) {
            throw new IllegalArgumentException("A posição já está ocupada: " + posicao);
        }
        getCasas().get(posicao).setPeca(peca);
        getPecasPorTime()
            .put(getCasas()
            .get(posicao).getPeca().getTime(), 
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao)
            .getPeca().getTime(), 0) + 1); // Incrementa o número de peças do time
    }

    public void moverPeca(Posicao origem, Posicao destino) {

        if (getCasas().get(origem) == null || getCasas().get(destino) == null) {
            throw new IllegalArgumentException("Posição de origem ou destino inválida.");
        }
        if (!getCasas().get(origem).estaOcupada()) {
            throw new IllegalArgumentException("Não há peça na posição de origem: " + origem);
        }

        getCasas().get(destino).setPeca(getCasas().get(origem).getPeca());
        getCasas().get(origem).setPeca(null);
        
    }

    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < getLinhas() && coluna >= 0 && coluna < getColunas();
    }

    public boolean posicaoValida(Posicao posicao) {
        return posicaoValida(posicao.getLinha(), posicao.getColuna());
    }

    public void RemoverPeca(Posicao posicao) throws VitoriaException{
        if(getVitoriaDerrotaObserver().verificarVencedor() != null){
           throw new VitoriaException("O jogo já acabou, não é possível remover peças. Ja temos um vencedor");
        }
        getPecasPorTime()
            .put(getCasas().get(posicao).getPeca().getTime(),// pego o time com base na peça que estiver na casa
            getPecasPorTime()
            .getOrDefault(getCasas().get(posicao).getPeca().getTime(), 0) - 1); // Decrementa o número de peças do time com base no que estiver na casa
        getCasas()
            .get(posicao)
            .setPeca(null);// Depois limpa a peca que estiver na casa
    }

    public Map<Time, Integer> getPecasPorTime() {
        return pecasPorTime;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }
    private void setLinhas(int linhas) {
        this.linhas = linhas;
    }
    private void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Casa getCasa(Posicao posicao) {
        return getCasas().get(posicao);
    }

    public Map<Posicao, Casa> getCasas() {
        return casas;
    }

    public void setPecasPorTime(Map<Time, Integer> pecasPorTime) {
        this.pecasPorTime = pecasPorTime;
    }
    public void setCasas(Map<Posicao, Casa> casas) {
        this.casas = casas;
    }

    public VitoriaDerrotaObserver getVitoriaDerrotaObserver() {
        return vitoriaDerrotaObserver;
    }

    public void setVitoriaDerrotaObserver(VitoriaDerrotaObserver vitoriaDerrotaObserver) {
        this.vitoriaDerrotaObserver = vitoriaDerrotaObserver;
    }
}
