package main.java.br.com.frameworkPpr.boardgame.pieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;
import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.game.gamerules.GerenciadorVitoriaDerrota.Observer;
import main.java.br.com.frameworkPpr.boardgame.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;

public abstract class Peca implements Observer{
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

    @Override
    public void update(String evento) {
        System.out.println("Peça" + getNome() + " recebeu notificação: " + evento);

        if (evento.startsWith("peça movida")) {
            String[] partes = evento.split(":");
            String[] posicoes = partes[1].trim().split(" para ");
            Posicao origem = new Posicao(Integer.parseInt(posicoes[0].split(",")[0]), Integer.parseInt(posicoes[0].split(",")[1]));
            Posicao destino = new Posicao(Integer.parseInt(posicoes[1].split(",")[0]), Integer.parseInt(posicoes[1].split(",")[1]));

            System.out.println("Movimento detectado de " + origem + " para " + destino);
        }
    }

}
