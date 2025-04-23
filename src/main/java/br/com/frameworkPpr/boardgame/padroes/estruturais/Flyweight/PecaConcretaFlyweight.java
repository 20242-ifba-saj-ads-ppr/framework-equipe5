package main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.flyweight;

import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.TimeMultiton;

public class PecaConcretaFlyweight implements PecaFlyweight {
    private final String tipo;
    private final TimeMultiton time;

    public PecaConcretaFlyweight(String tipo, TimeMultiton time) {
        this.tipo = tipo;
        this.time = time;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public TimeMultiton getTime() {
        return time;
    }

}
