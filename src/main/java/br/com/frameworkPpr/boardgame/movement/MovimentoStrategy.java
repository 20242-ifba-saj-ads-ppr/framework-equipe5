package main.java.br.com.frameworkPpr.boardgame.movement;

import java.util.List;

import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;

public interface MovimentoStrategy {
    List<Posicao> calcularMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro);
}
