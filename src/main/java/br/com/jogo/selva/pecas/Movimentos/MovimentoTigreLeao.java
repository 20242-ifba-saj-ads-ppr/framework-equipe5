import java.util.List;

import main.java.br.com.frameworkPpr.boardgame.game.Posicao;
import main.java.br.com.frameworkPpr.boardgame.game.Tabuleiro;
import main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.strategy.MovimentoStrategy;

public class MovimentoTigreLeao implements MovimentoStrategy {
    @Override
    public List<Posicao> calcularMovimentosPossiveis(Posicao atual, Tabuleiro tabuleiro) {
        List<Posicao> movimentos = new ArrayList<>();
        for (Direcao dir : Direcao.ortogonais()) {
            // Movimento normal
            Posicao destino = atual.mover(dir);
            if (tabuleiro.estaDentro(destino) && tabuleiro.ehTerra(destino)) {
                movimentos.add(destino);
            }
            // Pulo sobre a água
            Posicao pulo = atual;
            boolean podePular = false;
            while (tabuleiro.estaDentro(pulo.mover(dir)) && tabuleiro.ehAgua(pulo.mover(dir))) {
                pulo = pulo.mover(dir);
                if (tabuleiro.temRato(pulo)) {
                    podePular = false;
                    break;
                }
                podePular = true;
            }
            if (podePular) {
                Posicao depoisAgua = pulo.mover(dir);
                if (tabuleiro.estaDentro(depoisAgua) && tabuleiro.ehTerra(depoisAgua)) {
                    movimentos.add(depoisAgua);
                }
            }
        }
        return movimentos;
    }
}