package main.java.br.com.frameworkPpr.boardgame.pieces.decorators;

import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;

import java.util.List;

public class PecaPromovidaDecorator extends PecaDecorator {
    public PecaPromovidaDecorator(Peca pecaDecorada) {
        super(pecaDecorada);
    }

    @Override
    public List<Posicao> obterMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro) {
        // Lógica extra para peça promovida pode ser adicionada aqui
        return super.obterMovimentosPossiveis(posicaoAtual, tabuleiro);
    }
}
