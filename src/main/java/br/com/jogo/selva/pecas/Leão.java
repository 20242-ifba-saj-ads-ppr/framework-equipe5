package main.java.br.com.jogo.selva.pecas;

import java.util.List;
import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;
import main.java.br.com.frameworkPpr.boardgame.pieces.Peca;

public class Leão extends Peca {

    public Leão() {
        super();
    }
    
    public Leão(String tipo, MovimentoStrategy movimentoStrategy) {
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
    public void update(String evento) {
        super.update(evento);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void setTime(Time time2) {
        super.setTime(time2);
    }
}
