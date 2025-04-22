package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer;

import java.util.Objects;

import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;

public class VitoriaDerrotaObserver implements Observer, CondicaoDeVitoria{
    private Tabuleiro tabuleiro;

    public VitoriaDerrotaObserver(Tabuleiro tabuleiro) {
        setTabuleiro(tabuleiro);
    }

    @Override
    public Time verificarVencedor() {
        for (String time : Time.getChaves()) {// Para cada Chave de time registrado
            Time timeAtual = Time.getInstance(time);// Pego o time
            if (timeAtual.getQuantidadePecasDoTime() == 0) {// Verifico se a Qtd é igual a 0
                // Na primeira vez que ele identificar essa condição
                // Retorna o outro time como vencedor
                for (String outroTime : Time.getChaves()) {// Outro for para pegaro outro time
                    if (!Objects.equals(outroTime,time)) {// em que se o outro time não for iqual ao time
                        return Time.getInstance(outroTime);
                    }
                }
            }
        }
        return null; // Nenhum vencedor ainda
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

    @Override
    public void update(String evento) {
        Time vencedor = verificarVencedor();
        if (vencedor != null) {
            notificarVencedor(vencedor);
        }
    }
}
