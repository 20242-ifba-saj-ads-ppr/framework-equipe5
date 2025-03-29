package frameworkJogoDeTabuleiro.model.jogador;

import frameworkJogoDeTabuleiro.model.multiton.time.Time;
/**
 * Classe Jogador é a representação do objeto na partida.
 */

public class Jogador {
    private Time time;
    private String nome;

    public Jogador(Time time, String nome) {
        setNome(nome);
        setTime(time);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
