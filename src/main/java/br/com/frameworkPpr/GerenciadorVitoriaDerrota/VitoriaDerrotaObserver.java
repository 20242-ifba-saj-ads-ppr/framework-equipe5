package main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.board.Tabuleiro;

public class VitoriaDerrotaObserver {
    private Tabuleiro tabuleiro;
    private CondicaoDeVitoria condicaoDeVitoria;

    public void VitoriaDerrotaObserver(Tabuleiro tabuleiro, CondicaoDeVitoria condicaoDeVitoria) {
        this.tabuleiro = tabuleiro;
        this.condicaoDeVitoria = condicaoDeVitoria;
    }

    public void VerificarVencedor()
    {
        Time vencedor = condicaoDeVitoria.verificarVencedor(Tabuleiro.getPecasPorTime());
        if (vencedor != null) {
            System.out.println("O time " + vencedor + " venceu!"); 
        }
    }
}
