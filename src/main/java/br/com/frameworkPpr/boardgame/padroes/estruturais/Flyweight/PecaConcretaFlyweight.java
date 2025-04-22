package main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.flyweight;

import java.sql.Time;

public class PecaConcretaFlyweight implements PecaFlyweight {
    private final String tipo;
    private final Time time;

    public PecaConcretaFlyweight(String tipo, Time time) {
        this.tipo = tipo;
        this.time = time;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public Time getTime() {
        return time;
    }

}
