package main.java.br.com.frameworkPpr.boardgame.game;

import java.util.Map;



public interface TabuleiroInterface {
    void inicializarCasas(int linhas, int colunas);
    void colocarPeca(Peca peca, Posicao posicao, Map<Posicao,Casa> casas);
    void moverPeca(Posicao origem, Posicao destino, Map<Posicao,Casa> casas);
    void removerPeca(Posicao posicao);
}
