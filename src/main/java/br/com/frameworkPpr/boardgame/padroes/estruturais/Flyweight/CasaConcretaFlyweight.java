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
        // Como Flyweight, não armazena estado de ocupação real.
        // Retorna sempre false (ocupação é extrínseca, depende do contexto externo).
        return false;
    }

    @Override
    public Object getPeca() {
        // Flyweight não armazena peça, retorna sempre null
        return null;
    }

    @Override
    public void setPeca(PecaFlyweight peca) {
        // Flyweight não armazena peça, não faz nada
        // Método vazio propositalmente
    }
    
}
