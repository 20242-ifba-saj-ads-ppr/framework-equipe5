package main.java.br.com.frameworkPpr.xadrez.pieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.xadrez.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;

public abstract class Peca {
    private String nome;
    private Time time;
    private Map<String, Object> caracteristicas; 
    protected MovimentoStrategy movimentoStrategy;

    public Peca() {
        this.caracteristicas = new HashMap<>();
    }

    public Peca(String nome, Time time, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        this.nome = nome;
        this.time = time;
        this.movimentoStrategy = movimentoStrategy;
        this.caracteristicas = caracteristicas != null ? caracteristicas : new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Map<String, Object> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void adicionarCaracteristica(String chave, Object valor) {
        this.caracteristicas.put(chave, valor);
    }

    public Object obterCaracteristica(String chave) {
        return this.caracteristicas.get(chave);
    }

    public List<Posicao> obterMovimentosPossiveis(Posicao posicaoAtual, Tabuleiro tabuleiro) {
        return movimentoStrategy.calcularMovimentosPossiveis(posicaoAtual, tabuleiro);
    }

    public Time getTime() {
        return time;
    }
}
