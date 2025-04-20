package main.java.br.com.frameworkPpr.boardgame.pieces;

import java.util.Map;
import main.java.br.com.frameworkPpr.boardgame.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;

public abstract class PecaFactory {
    
    public abstract Peca criarPeca(String tipo, MovimentoStrategy movimentoStrategy);

    public Peca criarPecaGenerica(String nome, Time time, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        return new Peca(nome, time, movimentoStrategy, caracteristicas) {

            @Override
            public void update(String evento) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'update'");
            }};
        }
    }
