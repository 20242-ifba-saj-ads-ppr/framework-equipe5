package frameworkJogoDeTabuleiro;

/**
 * A classe FrameworkJogoDetabuleiro é um exemplo da aplicação 
 * do padrão de projeto Singleton. Ele é aplicado para estanciar o jogo de tabuleiro.
 * Isso garante que haja apenas uma instância do jogo de tabuleiro em toda a aplicação.
 */
public class FrameworkJogoDetabuleiro {
    private String nomeJogo;

    private static FrameworkJogoDetabuleiro estanciaJogo;


    private FrameworkJogoDetabuleiro(String nomeJogo) {
        setNomeJogo(nomeJogo);
    }

    public static FrameworkJogoDetabuleiro getIstance(String nomeJogo) {
        if(estanciaJogo == null){
            estanciaJogo = new FrameworkJogoDetabuleiro(nomeJogo);
        }
        return estanciaJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
}
