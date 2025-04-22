package main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.flyweight;

public class CasaConcretaFlyweight implements CasaFlyweight {
    private final String cor;
    private final int numero;

    public CasaConcretaFlyweight(String cor, int numero) {
        this.cor = cor;
        this.numero = numero;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public boolean estaOcupada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaOcupada'");
    }
    
}
