package frameworkJogoDeTabuleiro;

/**
 * A classe FrameworkJogoDetabuleiro é um exemplo da aplicação 
 * do padrão de projeto Singleton. Ele é aplicado para estanciar o jogo de tabuleiro.
 * Isso garante que haja apenas uma instância do jogo de tabuleiro em toda a aplicação.
 */
public class FrameworkJogoDeTabuleiro {


    private String nomeJogo;

    private static FrameworkJogoDeTabuleiro estanciaJogo;


    private FrameworkJogoDeTabuleiro(String nomeJogo) {
        setNomeJogo(nomeJogo);
    }

    public static FrameworkJogoDeTabuleiro getIstance(String nomeJogo) {
        if(getEstanciaJogo() == null){
            setEstanciaJogo(new FrameworkJogoDeTabuleiro(nomeJogo));
        }
        return getEstanciaJogo();
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    private void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
    private static FrameworkJogoDeTabuleiro getEstanciaJogo() {
        return estanciaJogo;
    }

    private static void setEstanciaJogo(FrameworkJogoDeTabuleiro estanciaJogo) {
        FrameworkJogoDeTabuleiro.estanciaJogo = estanciaJogo;
    }
}
