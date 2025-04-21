package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.state;

import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;

public interface EstadoJogo {
    void iniciarJogo();
    void pausarJogo();
    void finalizarJogo();
    void reiniciarJogo();
}
