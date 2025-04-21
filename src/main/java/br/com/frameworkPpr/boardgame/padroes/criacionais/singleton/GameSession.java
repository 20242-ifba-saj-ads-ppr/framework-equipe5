package main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.singleton;

import main.java.br.com.frameworkPpr.boardgame.game.Jogador;
import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;

public class GameSession {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private static GameSession instance;

    private GameSession(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public static synchronized GameSession getInstance(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        if (instance == null) {
            instance = new GameSession(jogador1, jogador2, tabuleiro);
        }
        return instance;
    }

    public static synchronized GameSession getInstance() {
        if (instance == null) {
            throw new IllegalStateException("GameSession ainda não foi inicializada.");
        }
        return instance;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void configurarTimes(String... nomesTimes) {
        for (String nomeTime : nomesTimes) {
            tabuleiro.registrarTime(nomeTime);
        }
    }

    public static synchronized void reset() {
        instance = null;
    }
}
