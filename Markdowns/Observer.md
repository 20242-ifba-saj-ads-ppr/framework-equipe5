# Observer

### Intenção -

Permitir a definição de um mecanismo de assinatura para notificar múltiplos objetos sobre qualquer evento que aconteça com o objeto observado.

### Motivação sem o Padrão -

Sem o uso do Observer a implementação do monitoramento e observação teria que ser direto no *Tabuleiro*, assim, ele precisaria conhecer todas as classes que dependem de mudanças no estado do jogo, como a de VitoriaDerrotaObserver. Adicionar novas classes que precisariam ser notificadas resultaria na modificação da classe *Tabuleiro* violando o princípio **open/closed**.

```java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.xadrez.pieces.Peca;

public class Tabuleiro {
    private Peca[][] pecas;
    private int pecasBrancas;
    private int pecasPretas;

    public Tabuleiro() {
        pecas = new Peca[8][8];
        pecasBrancas = 16;
        pecasPretas = 16;
    }

    public void removerPeca(int x, int y) {
        Peca peca = pecas[x][y];
        if (peca != null) {
            if (peca.getTime().equals("Branco")) {
                pecasBrancas--;
            } else if (peca.getTime().equals("Preto")) {
                pecasPretas--;
            }
            pecas[x][y] = null;

            // verificação de vitória diretamente no Tabuleiro
            if (pecasBrancas == 0) {
                System.out.println("Time Preto venceu!");
            } else if (pecasPretas == 0) {
                System.out.println("Time Branco venceu!");
            }
        }
    }
}
```

### UML sem o Observer -

<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\VitoriaDerrotaSemObserver.png">

### Motivação no contexto do Tabuleiro -

Com o uso do Observer, há o monitoramento do estado do jogo verificando se há um vencedor através o número de peças de cada time.

``` java
package main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota;

import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;

//Aqui é o strategy
// Interface que define um método para verificar a condição de vitória BASEADO NA QUANTIDADE DE PEÇAS DE CADA TIME
public interface CondicaoDeVitoria {
    //a chave Time representa um time (Branco ou Preto) e o valor representa a quantidade de peças que o time ainda possui
    //o retorno é um objeto Time que indica o vencedor
    //essa classe é usada dentro do Observer para verificar se um time venceu ou não
    Time verificarVencedor();
}

```

``` java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.observer.Observer;
import br.com.frameworkPpr.xadrez.pieces.Peca;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private Peca[][] pecas;
    private int pecasBrancas;
    private int pecasPretas;
    private List<Observer> observadores;

    public Tabuleiro() {
        pecas = new Peca[8][8];
        pecasBrancas = 16;
        pecasPretas = 16;
        observadores = new ArrayList<>();
    }

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores(String evento) {
        for (Observer observador : observadores) {
            observador.atualizar(evento);
        }
    }

    public void removerPeca(int x, int y) {
        Peca peca = pecas[x][y];
        if (peca != null) {
            if (peca.getTime().equals("Branco")) {
                pecasBrancas--;
            } else if (peca.getTime().equals("Preto")) {
                pecasPretas--;
            }
            pecas[x][y] = null;

            // Notificar observadores sobre o estado do jogo
            if (pecasBrancas == 0) {
                notificarObservadores("Time Preto venceu!");
            } else if (pecasPretas == 0) {
                notificarObservadores("Time Branco venceu!");
            }
        }
    }
}
```

``` java
package br.com.frameworkPpr.observer;

public class VitoriaDerrotaObserver implements Observer {
    @Override
    public void atualizar(String evento) {
        System.out.println("Notificação recebida: " + evento);
    }
}
```

### Participantes -

1. **Subject:** Tabuleiro -> ele é o objeto observado e notifica os observadores sobre mudanças no estado do jogo;
2. **Observer:** VioriaDerrotaObserver -> define a interface para ser notificado sobre eventos no SUBJECT (*Tabuleiro*);
3. **ConcreteObserver:** VitoriaDerrotaObserver -> implementa o observer e reage as notificações do *Tabuleiro*. Ele declara o vencedor quando notificado pelo Tabuleiro, por exemplo.

### UML com o Observer -

<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\estruturaVitoriaDerrotaObserver.png">
