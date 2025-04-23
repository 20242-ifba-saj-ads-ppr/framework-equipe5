package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.memento;

import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.game.Casa;
import main.java.br.com.frameworkPpr.boardgame.game.Posicao;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.TimeMultiton;

public class TabuleiroMemento {
    private final Map<Posicao, Casa> casasSnapshot;
    private final Map<TimeMultiton, Integer> pecasPorTimeSnapshot;

    public TabuleiroMemento(Map<Posicao, Casa> casas, Map<TimeMultiton, Integer> pecasPorTime) {
        this.casasSnapshot = casas;
        this.pecasPorTimeSnapshot = pecasPorTime;
    }

    public Map<Posicao, Casa> getCasasSnapshot() {
        return casasSnapshot;
    }

    public Map<TimeMultiton, Integer> getPecasPorTimeSnapshot() {
        return pecasPorTimeSnapshot;
    }
}
