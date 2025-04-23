package main.java.br.com.frameworkPpr.boardgame.game;

import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.TimeMultiton;

public class Jogador {
    private String nome;
    private TimeMultiton time;

    public Jogador(String nome, TimeMultiton time) {
        this.nome = nome;
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public TimeMultiton getTime() {
        return time;
    }
}
