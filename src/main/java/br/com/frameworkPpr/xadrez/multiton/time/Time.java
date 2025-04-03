package main.java.br.com.frameworkPpr.xadrez.multiton.time;

/**
 * Enum representa as duas equipes do jogo de tabuleiro.
 * Cada equipe tem um time associado.
 * Padrão de projeto: Enum Mutiton.
 *
 */

public enum Time {
    BRANCO("Branco"),
    PRETO("Preto");

    private final String tipo;

    Time (String tipo){
       this.tipo = tipo;
    }

    @Override
    public String toString(){
        return tipo;
    }
}
