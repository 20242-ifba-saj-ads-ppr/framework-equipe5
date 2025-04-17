package main.java.br.com.frameworkPpr.boardgame.game.gamerules.GerenciadorVitoriaDerrota;

import main.java.br.com.frameworkPpr.boardgame.multiton.time.Time;

//Aqui é o strategy
// Interface que define um método para verificar a condição de vitória BASEADO NA QUANTIDADE DE PEÇAS DE CADA TIME
public interface CondicaoDeVitoria {
    //a chave Time representa um time (Branco ou Preto) e o valor representa a quantidade de peças que o time ainda possui
    //o retorno é um objeto Time que indica o vencedor
    //essa classe é usada dentro do Observer para verificar se um time venceu ou não
    Time verificarVencedor();
}
