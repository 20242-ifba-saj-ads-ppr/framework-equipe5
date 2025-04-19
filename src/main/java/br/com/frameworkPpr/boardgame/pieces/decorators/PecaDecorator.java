package main.java.br.com.frameworkPpr.boardgame.pieces.decorators;

import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;
import java.util.List;
import java.util.Map;

public abstract class PecaDecorator extends Peca {
    protected Peca pecaDecorada;

    public PecaDecorator(Peca pecaDecorada) {
        this.pecaDecorada = pecaDecorada;
    }

    @Override
    public String getNome() {
        return pecaDecorada.getNome();
    }

    @Override
    public void setNome(String nome) {
        pecaDecorada.setNome(nome);
    }

    @Override
    public Map<String, Object> getCaracteristicas() {
        return pecaDecorada.getCaracteristicas();
    }

    @Override
    public void setCaracteristicas(Map<String, Object> caracteristicas) {
        pecaDecorada.setCaracteristicas(caracteristicas);
    }

    @Override
    public void adicionarCaracteristica(String chave, Object valor) {
        pecaDecorada.adicionarCaracteristica(chave, valor);
    }

    @Override
    public Object obterCaracteristica(String chave) {
        return pecaDecorada.obterCaracteristica(chave);
    }

    @Override
    public List<Posicao> obterMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro) {
        return pecaDecorada.obterMovimentosPossiveis(posicaoAtual, tabuleiro);
    }

    @Override
    public Time getTime() {
        return pecaDecorada.getTime();
    }
}
