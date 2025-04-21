package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.State;

public class EstadoPausado implements EstadoJogo{
    private final ContextoJogo contexto;    

    public EstadoPausado(ContextoJogo contexto) {
        this.contexto = contexto;
    }
    @Override
    public void iniciarJogo() {
        System.out.println("O jogo foi iniciado.");
        contexto.setEstadoAtual(new EstadoIniciado(contexto));
    }
    @Override
    public void pausarJogo() {
        System.out.println("O jogo já está pausado.");
    }
    @Override
    public void finalizarJogo() {
        System.out.println("O jogo foi finalizado.");
        contexto.setEstadoAtual(new EstadoFinalizado(contexto));
    }
}
