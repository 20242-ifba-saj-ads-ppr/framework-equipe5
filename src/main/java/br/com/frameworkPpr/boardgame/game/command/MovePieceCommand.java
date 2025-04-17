package main.java.br.com.frameworkPpr.boardgame.game.command;

import main.java.br.com.frameworkPpr.boardgame.board.tabuleiro.singletonEProxySecurity.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.board.Posicao;

public class MovePieceCommand implements Command {
    private Tabuleiro tabuleiro;
    private Posicao origem;
    private Posicao destino;

    public MovePieceCommand(Tabuleiro tabuleiro, Posicao origem, Posicao destino) {
        this.tabuleiro = tabuleiro;
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public void execute() {
        tabuleiro.moverPeca(origem, destino);
    }

    @Override
    public void undo() {
        tabuleiro.moverPeca(destino, origem);
    }
}
