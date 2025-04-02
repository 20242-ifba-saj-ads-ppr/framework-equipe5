package main.java.br.com.frameworkPpr.xadrez.board;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private Map<Posicao, Casa> casas;
    private Map<Time, Integer> pecasPorTime;

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        casas = new HashMap<>();
        this.pecasPorTime = new HashMap<>();
        pecasPorTime.put(Time.valueOf("Branco"), 0);
        pecasPorTime.put(Time.valueOf("Preto"), 0);

        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                casas.put(posicao, new Casa(posicao));
            }
        }
    }

    public Casa getCasa(Posicao posicao) {
        return casas.get(posicao);
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        Casa casa = casas.get(posicao);
        if (casa == null) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
        if (casa.estaOcupada()) {
            throw new IllegalArgumentException("A posição já está ocupada: " + posicao);
        }
        casa.setPeca(peca);

        Time time = peca.getTime();
        pecasPorTime.put(time, pecasPorTime.getOrDefault(time, 0) + 1); // Incrementa o número de peças do time
    }

    public void moverPeca(Posicao origem, Posicao destino) {
        Casa casaOrigem = casas.get(origem);
        Casa casaDestino = casas.get(destino);

        if (casaOrigem == null || casaDestino == null) {
            throw new IllegalArgumentException("Posição de origem ou destino inválida.");
        }
        if (!casaOrigem.estaOcupada()) {
            throw new IllegalArgumentException("Não há peça na posição de origem: " + origem);
        }

        Peca peca = casaOrigem.getPeca();
        casaOrigem.setPeca(null);
        casaDestino.setPeca(peca);
    }

    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean posicaoValida(Posicao posicao) {
        return posicaoValida(posicao.getLinha(), posicao.getColuna());
    }

    public void RemoverPeca(Posicao posicao)
    {
        Casa casa = casas.get(posicao);

        Peca peca = casa.getPeca();
        casa.setPeca(null);

        Time time = peca.getTime();
        pecasPorTime.put(time, pecasPorTime.getOrDefault(time, 0) - 1); // Decrementa o número de peças do time
    }

    public Map<Time, Integer> getPecasPorTime() {
        return pecasPorTime;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }
}
