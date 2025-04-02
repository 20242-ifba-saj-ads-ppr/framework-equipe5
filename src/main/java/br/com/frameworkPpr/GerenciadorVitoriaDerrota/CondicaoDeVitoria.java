package main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota;
//Aqui é o strategy
// Interface que define um método para verificar a condição de vitória BASEADO NA QUANTIDADE DE PEÇAS DE CADA TIME
public class CondicaoDeVitoria {
    //a chave Time representa um time (Branco ou Preto) e o valor representa a quantidade de peças que o time ainda possui
    //o retorno é um objeto Time que indica o vencedor
    //essa classe é usada dentro do Observer para verificar se um time venceu ou não
    Time verificarVencedor(Map<Time, Integer> pecasPorTime);
}
