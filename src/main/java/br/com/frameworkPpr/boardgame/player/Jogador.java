package main.java.br.com.frameworkPpr.boardgame.player;

import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;

public class Jogador {
    private String nome;
    private Time time;

    public Jogador(String nome, Time time) {
        this.nome = nome;
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public Time getTime() {
        return time;
    }
}
