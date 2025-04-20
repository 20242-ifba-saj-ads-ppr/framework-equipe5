package main.java.br.com.frameworkPpr.boardgame.pieces.decorators;

import java.util.List;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;

public class PecaPromovidaDecorator extends PecaDecorator {
    public PecaPromovidaDecorator(Peca pecaDecorada) {
        super(pecaDecorada);
    }

    @Override
    public List<Posicao> obterMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro) {
        // Lógica extra para peça promovida pode ser adicionada aqui
        return super.obterMovimentosPossiveis(posicaoAtual, tabuleiro);
    }

    @Override
    public void update(String evento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
