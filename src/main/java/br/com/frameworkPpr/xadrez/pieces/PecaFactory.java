package main.java.br.com.frameworkPpr.xadrez.pieces;

import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.movement.MovimentoStrategy;

public abstract class PecaFactory {
    
public abstract Peca criarPeca(String tipo, MovimentoStrategy movimentoStrategy);

    public Peca criarPecaGenerica(String nome, String cor, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        return new Peca(nome, cor, movimentoStrategy, caracteristicas) {
            // Implementação genérica para peças customizadas
        };
    }
}
