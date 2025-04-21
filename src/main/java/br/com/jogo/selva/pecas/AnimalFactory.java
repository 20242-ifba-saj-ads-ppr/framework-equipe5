package main.java.br.com.jogo.selva.pecas;

import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;
import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;
import main.java.br.com.frameworkPpr.boardgame.pieces.PecaFactory;

public class AnimalFactory extends PecaFactory {

    @Override
    public Peca criarPeca(String tipo, MovimentoStrategy movimentoStrategy) {
        switch (tipo) {
            case "Elefante" -> {
                return new Elefante(tipo,movimentoStrategy);
            }
            case "Leão" -> {
                return new Leão(tipo, movimentoStrategy);
            }
            case "Tigre" -> {
                return new Tigre(tipo, movimentoStrategy);
            }
            case "Lobo" -> {
                return new Lobo(tipo, movimentoStrategy);
            }
            case "Raposa" -> {
                return new Raposa(tipo, movimentoStrategy);
            }
            case "Gato" -> {
                return new Gato(tipo, movimentoStrategy);
            }
            case "Rato" -> {
                return new Rato(tipo, movimentoStrategy);
            }
            default -> throw new IllegalArgumentException("Tipo de peça desconhecido: " + tipo);
        }
    }
}
