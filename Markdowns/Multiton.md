# Multiton (Não GOF)

### Intenção-

[^K19]    

Permitir a criação de uma quantidade limitada de instâncias de determinada classe e fornecer um modo para recuperá-las.

### Motivação sem o Padrão -
Sem o multiton, o gerenciamento dos times teria que ser de forma manual com o uso de mapas para armazenar e recuperar as instâncias deles. Só que isso é menos eficiente uma vez que seria necessário acessar o mapa sempre que informações sobre um time fossem necessárias. Também não haveria garantia de unicidade para cada time podendo levar a inconsistências.

```java
package main.java.br.com.frameworkPpr.xadrez.multiton.time;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorTimes {
    private Map<String, Time> times;

    public GerenciadorTimes() {
        times = new HashMap<>();
        times.put("Branco", new Time("Branco"));
        times.put("Preto", new Time("Preto"));
    }

    public Time getTime(String nome) {
        return times.get(nome);
    }

    public void adicionarTime(String nome, Time time) {
        times.put(nome, time);
    }
}

class Time {
    private String nome;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```

``` java
GerenciadorTimes gerenciador = new GerenciadorTimes();
Time branco = gerenciador.getTime("Branco");
Time preto = gerenciador.getTime("Preto");
gerenciador.adicionarTime("Azul", new Time("Azul")); // Possível adicionar novos times manualmente
```

### UML sem multiton -
<img alt="Motivação sem multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\motivacao_sem_multiton.png">

### Motivação no contexto do Tabuleiro -

O multiton aqui é usado para representar times no tabuleiro através do **Enum** no qual há a definição explícita de instâncias possíveis (Branco e Preto). pode existir mais de um time, mas cada um é identificado de forma única. Com o encapsulamento do gerenciamento das instancias de time o controle fica centralizado pois para cada identificador a instância retornada sempre será a mesma.


- Com o Multiton, podemos definir instancias como identificação única para times em um jogo de tabuleiro: 
  
  - Considere que em um jogo de Tabuleiro, precisamos criar uma representação dos times Preto e Branco. Naturalmente, uma possibilidade seria utilizar a estratégia de Maps para gerenciar cada tipo de time, nesse sentido, teriamos uma classe para gerencia - los o que se institui uma forma legitma, porem ineficiente, visto que, todo momento que quisessemos acessar uma informação referente ao time teriamos que chamar o map para retirar as infos.
``` java
package main.java.br.com.frameworkPpr.xadrez.multiton.time;

/**
 * Enum representa as duas equipes do jogo de tabuleiro.
 * Cada equipe tem um time associado.
 * Padrão de projeto: Enum Mutiton.
 *
 */

public enum Time {
    BRANCO("Branco"),
    PRETO("Preto");

    private final String tipo;

    Time (String tipo){
       this.tipo = tipo;
    }

    @Override
    public String toString(){
        return tipo;
    }
}
```

``` java
Time branco = Time.getInstance("Branco");
Time preto = Time.getInstance("Preto");
Time azul = Time.getInstance("Azul"); // Garantido que "Azul" será único
```


### Participantes -
1. **Multiton:** (Enum Time)  Define duas instâncias de time (preto e branco);
2. **Client:** (Tabuleiro), Peca -> classes que utilizam as instâncias do multiton.


<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Multiton</figcaption>

### UML com multiton -

<img alt="Motivação com multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\DiagramasIMG\motivacao_com_multiton.png">


<figcaption>Exemplo de como o Multiton Pode ser Aplicado</figcaption>

Podemos simplificar isso aplicando o multiton, com o uso dele declarado 2 instancias fixas para representar esses times, afim de serem usadas em diversas funcionalidades. Alem disso, é garantido que cada enum de time terá acesso excusivo a valores de atributos explicitos.

