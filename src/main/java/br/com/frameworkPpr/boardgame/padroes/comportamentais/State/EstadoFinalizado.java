package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.State;

public class EstadoFinalizado implements EstadoJogo{
    private final ContextoJogo contexto;

    public EstadoFinalizado(ContextoJogo contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarJogo(){
        throw  new IllegalStateException("O jogo foi finalizado.");
    }

    @Override
    public void pausarJogo(){
        throw  new IllegalStateException("O jogo ja está finalizado.");
    }

    @Override
    public void reiniciarJogo(){
        System.out.println("O jogo foi reiniciado.");
        contexto.setEstadoAtual(new EstadoIniciado(contexto));
    }

    @Override
    public void finalizarJogo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarJogo'");
    }
}
