# Factory

### Intenção -

Fornecer uma interface para criação de objetos em uma superclasse porém as subclasses cotém permissão para alterar os tipos de objetos que serao criados.

### Motivação sem o Padrão -

Sem o uso do Factory a criação dos objetos seria feita diretamente no código do *Tabuleiro*. O acoplamento seria grande pois o *Tabuleiro* ia precisar conhecer detalhes da implementação de cada peça. Na crição de novas peças ou até na modificação da lógica de criação a classe Tabuleiro teria que ser modificada violando o princípio **open/closed**.

``` java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.xadrez.pieces.Peca;
import br.com.frameworkPpr.xadrez.movement.MovimentoRei;
import br.com.frameworkPpr.xadrez.movement.MovimentoRainha;
import br.com.frameworkPpr.xadrez.multiton.time.Time;

public class Tabuleiro {
    private Peca[][] pecas;

    public Tabuleiro() {
        pecas = new Peca[8][8];
        inicializarPecas();
    }

    private void inicializarPecas() {
        // Criando peças diretamente Tabuleiro
        pecas[0][0] = new Peca("Rei", Time.BRANCO, new MovimentoRei(), null);
        pecas[0][1] = new Peca("Rainha", Time.BRANCO, new MovimentoRainha(), null);
        pecas[7][0] = new Peca("Rei", Time.PRETO, new MovimentoRei(), null);
        pecas[7][1] = new Peca("Rainha", Time.PRETO, new MovimentoRainha(), null);
    }
}
```

### UML sem Factory -

<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\PecaSemFactory.png">

### Motivação no contexto do tabuleiro -

Com a aplicação do Factory, são criadas instâncias de peças, ele encapsula a lógica da criação, permitindo que novas peças sejam adicionadas sem modificar o código existente. O método *criarPecaGenerica* permite a criação de peças com características personalizadas.

```java
package main.java.br.com.frameworkPpr.xadrez.pieces;

import java.util.Map;

import main.java.br.com.frameworkPpr.xadrez.movement.MovimentoStrategy;
import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;

public abstract class PecaFactory {
    
    public abstract Peca criarPeca(String tipo, MovimentoStrategy movimentoStrategy);

    public Peca criarPecaGenerica(String nome, Time time, MovimentoStrategy movimentoStrategy, Map<String, Object> caracteristicas) {
        return new Peca(nome, time, movimentoStrategy, caracteristicas) {};
    }
}
```

Uso na classe Tabuleiro:

```java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.xadrez.pieces.Peca;
import br.com.frameworkPpr.xadrez.factory.PecaFactory;
import br.com.frameworkPpr.xadrez.multiton.time.Time;

public class Tabuleiro {
    private Peca[][] pecas;

    public Tabuleiro() {
        pecas = new Peca[8][8];
        inicializarPecas();
    }

    private void inicializarPecas() {
        pecas[0][0] = PecaFactory.criarPeca("Rei", Time.BRANCO);
        pecas[0][1] = PecaFactory.criarPeca("Rainha", Time.BRANCO);
        pecas[7][0] = PecaFactory.criarPeca("Rei", Time.PRETO);
        pecas[7][1] = PecaFactory.criarPeca("Rainha", Time.PRETO);
    }
} 
```

### Participantes -

1. **Produto:** Peca -> define a interface base para os objetos que serão criados;
2. **Factory:** PecaFactory -> contém o método responsável por criar as instâncias das peças.
3. **Client:** Tabuleiro -> classe que utiliza a fábrica para criar objetos.

### UML com Factory -

<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\PecaComFactory.png">
