package main.java.br.com.jogo.selva.pecas;

import java.util.List;
import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.game.Posicao;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.strategy.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.factory.Peca;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;
import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;

public class Raposa extends Peca{

    public Raposa() {
        super();
    }

    public Raposa(String tipo, MovimentoStrategy movimentoStrategy) {
        super(tipo, null, movimentoStrategy, null);
    }
    @Override
    public void adicionarCaracteristica(String chave, Object valor) {
        super.adicionarCaracteristica(chave, valor);
    }

    @Override
    public Map<String, Object> getCaracteristicas() {
        return super.getCaracteristicas();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Time getTime() {
        return super.getTime();
    }

    @Override
    public Object obterCaracteristica(String chave) {
        return super.obterCaracteristica(chave);
    }

    @Override
    public List<Posicao> obterMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro) {
        return super.obterMovimentosPossiveis(posicaoAtual, tabuleiro);
    }

    @Override
    public void setCaracteristicas(Map<String, Object> caracteristicas) {
        super.setCaracteristicas(caracteristicas);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void update(String evento) {
        super.update(evento);
    }
    @Override
    public void setTime(Time time2) {
        super.setTime(time2);
    }
}
