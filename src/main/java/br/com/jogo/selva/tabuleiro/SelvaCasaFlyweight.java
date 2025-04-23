package main.java.br.com.jogo.selva.tabuleiro;

import main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.flyweight.CasaFlyweight;

public class SelvaCasaFlyweight implements CasaFlyweight {
    private final SelvaCasaType tipo;
    private final int numero;

    public SelvaCasaFlyweight(SelvaCasaType tipo, int numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    // Retorna o tipo como "cor" para compatibilidade com a interface
    @Override
    public String getCor() {
        return tipo.name();
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public boolean estaOcupada() {
        // O estado de ocupação é extrínseco e deve ser controlado fora do Flyweight
        throw new UnsupportedOperationException("Ocupação deve ser controlada externamente ao Flyweight.");
    }

    public SelvaCasaType getTipo() {
        return tipo;
    }
}