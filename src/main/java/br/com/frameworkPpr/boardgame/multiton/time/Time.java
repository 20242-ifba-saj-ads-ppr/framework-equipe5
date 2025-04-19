package main.java.br.com.frameworkPpr.boardgame.multiton.time;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;

/**
 * Enum representa as duas equipes do jogo de tabuleiro.
 * Cada equipe tem um time associado.
 * Padrão de projeto: Enum Mutiton.
 */

public enum Time {
    BRANCO("Branco"),
    PRETO("Preto");

    private final String tipo;
    private List<Peca> pecas;

    Time(String tipo) {
        this.tipo = tipo;
        setPecas(new ArrayList<>());
    }

    // Método para adicionar peças ao time com base na referencia da estancia
    // Exemplo: Time.BRANCO.adicionarPecasAoTime(peca);
    // Isso garante que as peças sejam adicionadas ao time correto.
    public boolean adicionarPecasAoTime(Peca peca) {
        return getPecas().add(peca);
    }

    // Método para listar peças do time com base na referencia da estancia
    // Exemplo: Time.BRANCO.getPecasDoTime();
    // Isso garante que as peças sejam listadas do time correto.
    public List<Peca> getPecasDoTime() {
        return getPecas();
    }

    // Método para remover peças do time com base na referencia da estancia
    // Exemplo: Time.BRANCO.removerPecaDoTime(peca);
    // Isso garante que as peças sejam removidas do time correto.
    public boolean removerPecaDoTime(Peca peca) {
        return getPecas().remove(peca);
    }

    // Pega a quantidade de peças do time com base na referencia da instancia
    // Exemplo: Time.BRANCO.getQuantidadePecasDoTime();
    // Isso garante que a quantidade de peças seja retornada do time correto.
    public int getQuantidadePecasDoTime() {
        return getPecas().size();
    }

    @Override
    public String toString() {
        return tipo;
    }

    private List<Peca> getPecas() {
        return pecas;
    }

    private void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }
}
