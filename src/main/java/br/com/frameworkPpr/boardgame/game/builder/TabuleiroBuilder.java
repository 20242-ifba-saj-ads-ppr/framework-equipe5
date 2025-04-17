package main.java.br.com.frameworkPpr.boardgame.game.builder;

import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;

public abstract class TabuleiroBuilder {
    protected Tabuleiro tabuleiro;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void criarNovoTabuleiro() {
        tabuleiro = Tabuleiro.getInstance();
    }

    public abstract void construirCasas(int linhas, int colunas);
    public abstract void posicionarPecasIniciais();
}
