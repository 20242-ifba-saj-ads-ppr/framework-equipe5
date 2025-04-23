package main.java.br.com.frameworkPpr.boardgame.game;

/**
 * Classe que representa uma casa no tabuleiro de xadrez.
 * Cada casa possui uma posição e pode conter uma peça.
 */
public class Casa {
    private Posicao posicao;
    private Peca peca;

    /**
     * Construtor que inicializa a casa com uma posição específica.
     * @param posicao A posição da casa no tabuleiro.
     */
    public Casa(Posicao posicao) {
        this.posicao = posicao;
        this.peca = null; // Inicialmente, a casa não contém peça
    }

    // Getters e setters
    public Posicao getPosicao() {
        return posicao;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    /**
     * Verifica se a casa está ocupada por uma peça.
     * @return true se a casa contém uma peça, false caso contrário.
     */
    public boolean estaOcupada() {
        return this.peca != null;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "posicao=" + posicao +
                ", peca=" + (peca != null ? peca.getClass().getSimpleName() : "vazia") +
                '}';
    }

    public String getTipo() {
        return peca != null ? peca.getClass().getSimpleName() : "vazia";
    }
}

