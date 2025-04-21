package main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.factory;

import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.strategy.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;

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
