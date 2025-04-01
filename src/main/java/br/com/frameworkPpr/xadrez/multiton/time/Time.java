package main.java.br.com.frameworkPpr.xadrez.multiton.time;

/**
 * Enum representa as duas equipes do jogo de tabuleiro.
 * Cada equipe tem um time associado.
 * Padrão de projeto: Enum Mutiton.
 *
 */

public enum Time {
    BRANCO(1),
    PRETO(2);

    private int tipo;

    Time (int tipo){
        setTipo(tipo);
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
