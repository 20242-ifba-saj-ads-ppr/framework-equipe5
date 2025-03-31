package main.java.br.com.frameworkPpr.xadrez.board;

import java.util.HashMap;
import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

/**
 * Classe que representa o tabuleiro de xadrez.
 * Utiliza o padrão Composite para gerenciar as casas e peças.
 */
public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private Map<Posicao, Casa> casas;

    /**
     * Construtor que inicializa o tabuleiro com todas as casas.
     * @param linhas Número de linhas do tabuleiro.
     * @param colunas Número de colunas do tabuleiro.
     */
    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        casas = new HashMap<>();
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                Posicao posicao = new Posicao(linha, coluna);
                casas.put(posicao, new Casa(posicao));
            }
        }
    }

    /**
     * Obtém a casa na posição especificada.
     * @param posicao A posição da casa.
     * @return A casa correspondente à posição.
     */
    public Casa getCasa(Posicao posicao) {
        return casas.get(posicao);
    }

    /**
     * Coloca uma peça na posição especificada.
     * @param peca A peça a ser colocada.
     * @param posicao A posição onde a peça será colocada.
     * @throws IllegalArgumentException Se a posição não for válida ou já estiver ocupada.
     */
    public void colocarPeca(Peca peca, Posicao posicao) {
        Casa casa = casas.get(posicao);
        if (casa == null) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
        if (casa.estaOcupada()) {
            throw new IllegalArgumentException("A posição já está ocupada: " + posicao);
        }
        casa.setPeca(peca);
    }

    /**
     * Move uma peça de uma posição para outra.
     * @param origem Posição de origem.
     * @param destino Posição de destino.
     * @throws IllegalArgumentException Se a posição de origem ou destino não for válida,
     *                                  se não houver peça na origem ou se o movimento não for permitido.
     */
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
        // Aqui você pode adicionar a lógica para verificar se o movimento é válido
        // com base nas regras específicas da peça e do jogo.

        casaOrigem.setPeca(null);
        casaDestino.setPeca(peca);
    }

    /**
     * Verifica se uma posição está dentro dos limites do tabuleiro.
     * @param linha Índice da linha.
     * @param coluna Índice da coluna.
     * @return true se a posição for válida, false caso contrário.
     */
    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    /**
     * Verifica se uma posição está dentro dos limites do tabuleiro.
     * @param posicao A posição a ser verificada.
     * @return true se a posição for válida, false caso contrário.
     */
    public boolean posicaoValida(Posicao posicao) {
        return posicaoValida(posicao.getLinha(), posicao.getColuna());
    }

    /**
     * Retorna o número de linhas do tabuleiro.
     * @return O número de linhas do tabuleiro.
     */
    public int getLinhas() {
        return this.linhas;
    }

    /**
     * Retorna o número de colunas do tabuleiro.
     * @return O número de colunas do tabuleiro.
     */
    public int getColunas() {
        return this.colunas;
    }
}
