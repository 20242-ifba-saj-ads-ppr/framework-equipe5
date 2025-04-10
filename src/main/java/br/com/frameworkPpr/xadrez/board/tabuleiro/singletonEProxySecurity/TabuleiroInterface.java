package main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity;

import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.board.Casa;
import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

public interface TabuleiroInterface {
    void inicializarCasas(int linhas, int colunas);
    void colocarPeca(Peca peca, Posicao posicao, Map<Posicao,Casa> casas);
    void moverPeca(Posicao origem, Posicao destino, Map<Posicao,Casa> casas);
    void removerPeca(Posicao posicao);
}
