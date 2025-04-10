package main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota;


import java.util.HashMap;
import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;

public class VitoriaDerrotaObserver implements CondicaoDeVitoria{
    private Tabuleiro tabuleiro;

    public VitoriaDerrotaObserver(Tabuleiro tabuleiro) {
        setTabuleiro(tabuleiro);
    }

    @Override
    public Time verificarVencedor(){
        return getTabuleiro().getPecasPorTime().get(Time.BRANCO) == 0? 
                Time.PRETO 
                : getTabuleiro().getPecasPorTime().get(Time.PRETO) == 0? 
                Time.BRANCO 
                : null;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
