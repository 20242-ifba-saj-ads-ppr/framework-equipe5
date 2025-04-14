# Proxy
### Intenção -
atuar como intermediário entre o cliente e um objeto real, controlando o acesso a ele.

### Motivação Sem o Padrão -
Sem o Proxy as classes *Peca* e *VitoriaDerrotaObserver* teriam que interagir diretamente com o objeto real *Tabuleiro*. Isso levaria a falta de controle de acesso já que não há uma camada intermediária para validar as ações antes executar. Operações inválidas poderiam ser realizadas no *Tabuleiro* e as lógicas de validações teriam de ser implementadas direto nessa classe.

``` java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.xadrez.pieces.Peca;

public class Tabuleiro {
    private Peca[][] pecas;

    public Tabuleiro() {
        pecas = new Peca[8][8];
    }

    public void colocarPeca(Peca peca, int x, int y) {
        // Sem validações
        pecas[x][y] = peca;
    }

    public Peca obterPeca(int x, int y) {
        return pecas[x][y];
    }
}
```
### UML sem Proxy -
<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\TabuleiroSemProxy.png">

### Motivação no Contexto do tabuleiro -
Com o uso do Proxy, o acesso ao tabuleiro é protegido e certas ações, como iniciar o jogo, são verificadas antes da execução.
ex: antes de colocar uma peça no tabuleiro, o método **colocarPeca** verifica se a posição é valida e se o jogo já foi iniciado.

``` java
package br.com.frameworkPpr.xadrez.board;

import br.com.frameworkPpr.xadrez.pieces.Peca;

public class TabuleiroProxySecurity {
    private Tabuleiro tabuleiro;
    private boolean jogoIniciado;

    public TabuleiroProxySecurity() {
        this.tabuleiro = new Tabuleiro();
        this.jogoIniciado = false;
    }

    public void iniciarJogo() {
        this.jogoIniciado = true;
    }

    public void colocarPeca(Peca peca, int x, int y) {
        if (!jogoIniciado) {
            throw new IllegalStateException("O jogo ainda não foi iniciado!");
        }
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
        if (tabuleiro.obterPeca(x, y) != null) {
            throw new IllegalStateException("Já existe uma peça nessa posição!");
        }
        tabuleiro.colocarPeca(peca, x, y);
    }

    public Peca obterPeca(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
        return tabuleiro.obterPeca(x, y);
    }
}
```

### Participantes -
1. **Proxy:** TabuleiroProxySecurity -> ele atua como intermediário entre o cliente e o objeto real, que é o Tabuleiro;
2. **Objeto real:** Tabuleiro -> contém a lógica principal do jogo, como gerenciar casas, peças e as interações. O *TabuleiroProxySecurity* delega as operações ao *Tabuleiro* após realizar as validações necessárias.
3. **Cliente:** Peca, VitoriaDerrotaObserver -> classes que interagem com o abuleiro por meio do proxy.

### UML com Proxy -
<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\TabuleiroComProxy.png">

