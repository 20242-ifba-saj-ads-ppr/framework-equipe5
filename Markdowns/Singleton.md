# Singleton

### Intenção -
garantir que uma classe possua apenas uma isntância e provê um ponto de acesso global a ela.

### Motivação sem o Padrão -
sem a aplicação do padrão, seria necessária a criação de várias instâncias do Tabuleiro causando duplicidade e falta de controle já que haveria múltiplos tabuleiros criados sendo possível a criação de vários jogos sem a centralização desses.

``` java 
package br.com.frameworkPpr.xadrez.board;

public class Tabuleiro {
    private int[][] estado;

    // Construtor público para permitir múltiplas instâncias
    public Tabuleiro() {
        // Inicializa o tabuleiro com o estado inicial
        estado = new int[8][8];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        //preencher com peças
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                estado[i][j] = 0; // 0 representa uma célula vazia
            }
        }
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] novoEstado) {
        this.estado = novoEstado;
    }
}
```

### UML sem singleton:
<img alt="Motivação sem Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\motivacao_sem_singleton.png">

### Motivação no contexto do Tabuleiro -
unicidade do tabuleiro já que ele é um recurso central e único, varias instâncias dele causaria inconsistência no estado do jogo. Com o acesso globaç, outras partes do sistema, peças, jogadores, regras... podem interagir de forma consistente. 

``` java
package main.java.br.com.frameworkPpr.xadrez.board.tabuleiro.singletonEProxySecurity;
import java.util.HashMap;
import java.util.Map;
import main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota.VitoriaDerrotaObserver;
import main.java.br.com.frameworkPpr.GerenciadorVitoriaDerrota.VitoriaException;
import main.java.br.com.frameworkPpr.xadrez.board.Casa;
import main.java.br.com.frameworkPpr.xadrez.board.Posicao;
import main.java.br.com.frameworkPpr.xadrez.multiton.time.Time;
import main.java.br.com.frameworkPpr.xadrez.pieces.Peca;

/**
 * A classe Tabuleiro é um exemplo da aplicação do padrão de projeto Singleton. Ele é aplicado para instanciar o jogo de tabuleiro.
 * Isso garante que haja apenas uma instância do jogo de tabuleiro em toda a aplicação.
 * Nessa casse terá apenas a lógica de negócio do tabuleiro, ou seja, o que pode ser feito no tabuleiro.
 */
public class Tabuleiro {
    private Map<Posicao, Casa> casas;
    private Map<Time, Integer> pecasPorTime;
    private VitoriaDerrotaObserver vitoriaDerrotaObserver;
    private static Tabuleiro instance;
    // Instancia do TabuleiroProxySecurity(Singleton) para validações de jogo
    private static TabuleiroProxySecurity proxySecurityInstance;

    private Tabuleiro() {
        setProxySecurityInstance(TabuleiroProxySecurity.getInstance());
        setCasas(new HashMap<>());
        setPecasPorTime(new HashMap<>());
        getPecasPorTime().put(Time.BRANCO, 0);
        getPecasPorTime().put(Time.PRETO, 0);
        setVitoriaDerrotaObserver(new VitoriaDerrotaObserver(this));
    }

    public static Tabuleiro getInstance() { 
        synchronized (Tabuleiro.class){
            if (instance == null) {
                instance = new Tabuleiro();
            }
        }
        return instance;
    }
    //... continua no script Tabuleiro.java
}
```

### Participantes -
1.  **Singelton:**
    representado pela classe **tabuleiro** através de uma construtor privado, um método estático getInstance() que retorna a instância única dessa classe.
2. **Client:**
   são as **peças**, **jogadores**, **regras do jogo**.


### UML com singleton:
<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\motivacao_com_singleton.png">






