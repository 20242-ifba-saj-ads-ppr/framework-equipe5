package main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity;

import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.board.Casa;
import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

/**
 * A classe TabuleiroProxySecurity é um exemplo da aplicação do padrão de projeto estrutural Proxy.
 * Ele é aplicado para que antes de realizar qualquer ação,
 * O tabuleiro passa a responsabilidade para ele, quem instancia o tabuleiro não sabe, 
 * 
 * E tambem há a aplicação o Singleton, isso garante que haja apenas uma instância do proxy no mesmo pacote.
 * Nessa casse terá apenas a lógica validação de inicio do jogo antes de execurar as operações 
 * Toda a logica de movimentação é de responsabiidade da classe Tabuleiro
 */
class TabuleiroProxySecurity implements TabuleiroInterface {
    private int linhas;
    private int colunas;
    private static TabuleiroProxySecurity proxyInstance;
    private boolean jogoIniciado;


    private TabuleiroProxySecurity() {
        setJogoIniciado(false);
    }

    static TabuleiroProxySecurity getInstance() {
        synchronized (TabuleiroProxySecurity.class) {
            if (getProxyInstance() == null) {
                setProxyInstance(new TabuleiroProxySecurity());
            }
        }
        return getProxyInstance();
    }

    private void verificarJogoIniciado() {
        if (!isJogoIniciado()) {
            throw new IllegalStateException("O jogo ainda não foi iniciado.");
        }
    }

    @Override
    public void inicializarCasas(int linhas, int colunas) {
        if (getLinhas() != 0 && getColunas() != 0) {
            throw new IllegalArgumentException("O tabuleiro já foi inicializado. Não é possível redefinir o tamanho.");   
        } 
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("O número de linhas e colunas deve ser maior que zero.");
        }
        setLinhas(linhas);
        setColunas(colunas);
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < getLinhas() && coluna >= 0 && coluna < getColunas();
    }

    private boolean posicaoValida(Posicao posicao) {
        return posicaoValida(posicao.getLinha(), posicao.getColuna());
    }

    @Override
    public void colocarPeca(Peca peca, Posicao posicao, Map<Posicao,Casa> casas) {
        verificarJogoIniciado();
        if (casas.get(posicao) == null) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
        if (casas.get(posicao).estaOcupada()) {
            throw new IllegalArgumentException("A posição já está ocupada: " + posicao);
        }
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
    }

    @Override
    public void moverPeca(Posicao origem, Posicao destino, Map<Posicao,Casa> casas) {
        verificarJogoIniciado();
        if (!posicaoValida(origem) || !posicaoValida(destino)) {
            throw new IllegalArgumentException("Posição de origem ou destino inválida.");
        }
        if (casas.get(origem) == null || casas.get(destino) == null) {
            throw new IllegalArgumentException("Posição de origem ou destino inválida.");
        }
        if (!casas.get(origem).estaOcupada()) {
            throw new IllegalArgumentException("Não há peça na posição de origem: " + origem);
        }
    }

    @Override
    public void removerPeca(Posicao posicao) {
        verificarJogoIniciado();
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida: " + posicao);
        }
    }

    private int getColunas() {
        return colunas;
    }

    private void setColunas(int colunas) {
        this.colunas = colunas;
    }
    private int getLinhas() {
        return linhas;
    }

    private void setLinhas(int linhas) {
        this.linhas = linhas;
    }
    private static TabuleiroProxySecurity getProxyInstance() {
        return proxyInstance;
    }

    private boolean isJogoIniciado() {
        return jogoIniciado;
    }

    void setJogoIniciado(boolean jogoIniciado) {
        this.jogoIniciado = jogoIniciado;
    }
    private static void setProxyInstance(TabuleiroProxySecurity proxyInstance) {
        TabuleiroProxySecurity.proxyInstance = proxyInstance;
    }
}   

