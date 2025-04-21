package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer;

import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;
import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;

public class VitoriaDerrotaObserver implements CondicaoDeVitoria{
    private Tabuleiro tabuleiro;

    public VitoriaDerrotaObserver(Tabuleiro tabuleiro) {
        setTabuleiro(tabuleiro);
    }

    @Override
    public Time verificarVencedor(){
        return getTabuleiro().getPecasPorTime().get(Time.getInstance("Branco")) == 0? 
                Time.getInstance("Preto") 
                : getTabuleiro().getPecasPorTime().get(Time.getInstance("Preto")) == 0? 
                Time.getInstance("Branco") 
                : null;
    }

    public void notificarVencedor(Time vencedor)
    {
        System.out.println("Vencedor: " + vencedor);
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
