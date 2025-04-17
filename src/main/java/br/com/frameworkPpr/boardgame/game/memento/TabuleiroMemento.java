package main.java.br.com.frameworkPpr.boardgame.game.memento;

import java.util.Map;
import main.java.br.com.frameworkPpr.boardgame.board.Casa;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;

public class TabuleiroMemento {
    private final Map<Posicao, Casa> casasSnapshot;
    private final Map<Time, Integer> pecasPorTimeSnapshot;

    public TabuleiroMemento(Map<Posicao, Casa> casas, Map<Time, Integer> pecasPorTime) {
        this.casasSnapshot = casas;
        this.pecasPorTimeSnapshot = pecasPorTime;
    }

    public Map<Posicao, Casa> getCasasSnapshot() {
        return casasSnapshot;
    }

    public Map<Time, Integer> getPecasPorTimeSnapshot() {
        return pecasPorTimeSnapshot;
    }
}
