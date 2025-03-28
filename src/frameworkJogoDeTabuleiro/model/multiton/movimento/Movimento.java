package frameworkJogoDeTabuleiro.model.multiton.movimento;

/**
 * Enum representa as possiveis movimentações da peça no jogo de tabuleiro.
 * Cada peça pode se movimentar varias vezes considerando o plano cartesiano do tabuleiro.
 * Padrão de projeto: Enum Mutiton.
 */

public enum Movimento {
    PRAFRENTE(0, 1),
    PRATRAZ(0,-1),
    ESQUERDA(-1, 0),
    DIREITA(+1, 0);
    
    private int x;
    private int y;


    public int getY() {
        return y;
    }

    Movimento (int x, int y){
       setX(x);
       setY(y);
    }

    public void setY( int y) {
        this.y = y;
    }
    public int getX (){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }
}
