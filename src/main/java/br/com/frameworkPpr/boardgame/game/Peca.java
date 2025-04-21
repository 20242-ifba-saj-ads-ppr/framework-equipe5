package main.java.br.com.frameworkPpr.boardgame.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer.Observer;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.strategy.MovimentoStrategy;
import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;

public abstract class Peca implements Observer{
    private String nome;
    private Time time;
    private Map<String, Object> caracteristicas; 
    protected MovimentoStrategy movimentoStrategy;

    public Peca() {
        this.caracteristicas = new HashMap<>();
    }

    public Peca(String nome, Time time, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        setNome(nome);
        setTime(time);
        this.movimentoStrategy = movimentoStrategy;
        setCaracteristicas(caracteristicas != null ? caracteristicas : new HashMap<>());
    }
    public void setTime(Time time2) {
        this.time = time2;
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

    @Override
    public String toString() {
        return "Peca [nome=" + nome + ", time=" + time + ", caracteristicas=" + caracteristicas + ", movimentoStrategy="
                + movimentoStrategy + "]";
    }
}
