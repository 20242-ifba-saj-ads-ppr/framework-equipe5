package main.java.br.com.frameworkPpr.xadrez.pieces;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.board.Tabuleiro;
import main.java.br.com.frameworkPpr.xadrez.movement.MovimentoStrategy;

public abstract class Peca {
    private String nome;
    private String cor;
    private Time time;
    private Map<String, Object> caracteristicas; 
    protected MovimentoStrategy movimentoStrategy;

    public Peca() {
        this.caracteristicas = new HashMap<>();
    }

    public Peca(String nome, String cor, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        this.nome = nome;
        this.cor = cor;
        this.movimentoStrategy = movimentoStrategy;
        this.caracteristicas = caracteristicas != null ? caracteristicas : new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
