package main.java.br.com.frameworkPpr.xadrez.movement;

import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity.Tabuleiro;

import java.util.List;

public interface MovimentoStrategy {
    List<Posicao> calcularMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro);
}
