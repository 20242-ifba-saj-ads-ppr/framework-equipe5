package main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.builder;

import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;

public class TabuleiroDirector {
    private final TabuleiroBuilder builder;

    public TabuleiroDirector(TabuleiroBuilder builder) {
        this.builder = builder;
    }

    public Tabuleiro construir(int largura, int altura) {
        builder.iniciarTabuleiro(largura, altura);
        builder.adicionarCasas();
        builder.adicionarPecas();
        return builder.getResultado();
    }
}

