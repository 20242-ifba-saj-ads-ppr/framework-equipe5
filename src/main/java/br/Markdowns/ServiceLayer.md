# Service Layer

### Intenção

- Organizar a lógica de negócio em uma camada de serviços, separando-a das camadas de apresentação e persistência.
- Fornecer uma interface de alto nível para operações de negócio, promovendo a reutilização, a manutenção e a testabilidade.

### Motivação

- No framework, a classe `Tabuleiro` concentra a lógica de negócio relacionada ao tabuleiro.
- A camada de serviço atua como um intermediário entre a lógica de negócio e outras camadas, como a de apresentação, reduzindo o acoplamento.
- A lógica de validação é delegada ao `TabuleiroProxySecurity`, enquanto o `Tabuleiro` foca nas operações de alto nível.

#### Sem o Service Layer

- Sem uma camada de serviço, a lógica de negócio ficaria espalhada entre diferentes classes, dificultando a manutenção e a reutilização.
- A classe `Tabuleiro` seria responsável tanto pela lógica de negócio quanto por interações diretas com outras classes, violando o princípio de responsabilidade única.
- A lógica de validação e manipulação de dados ficaria misturada, tornando o código mais difícil de entender e testar.

#### Com o Service Layer

- Com uma camada de serviço, a lógica de negócio do tabuleiro é encapsulada na classe `Tabuleiro`, que fornece métodos de alto nível para inicializar o tabuleiro, gerenciar peças e realizar movimentos.
- O `TabuleiroProxySecurity` atua como um validador, garantindo que as operações sejam realizadas apenas em condições válidas.
- Isso promove a separação de responsabilidades, facilita a manutenção e permite a reutilização de funcionalidades em diferentes contextos.

### Exemplo no Framework

```java
Tabuleiro tabuleiro = Tabuleiro.getInstance();

// Inicializar o tabuleiro
tabuleiro.inicializarCasas(8, 8);

// Colocar uma peça no tabuleiro
tabuleiro.colocarPeca(peca, new Posicao(0, 0));

// Mover uma peça no tabuleiro
tabuleiro.moverPeca(new Posicao(0, 0), new Posicao(1, 1));

// Remover uma peça do tabuleiro
tabuleiro.removerPeca(new Posicao(1, 1));
```

### Benefícios

- **Redução de acoplamento**: A lógica de negócio está isolada na classe `Tabuleiro`, enquanto as validações estão no `TabuleiroProxySecurity`.
- **Facilidade de manutenção**: Alterações na lógica de negócio podem ser feitas na classe `Tabuleiro` sem impactar outras partes do sistema.
- **Reutilização**: A lógica encapsulada na classe `Tabuleiro` pode ser reutilizada em diferentes contextos.
- **Testabilidade**: A lógica de negócio é mais fácil de testar de forma isolada.

### Estrutura no Framework

#### Tabuleiro (Service Layer)
- Concentra a lógica de negócio do tabuleiro.
- Fornece métodos de alto nível para inicializar, gerenciar e manipular o tabuleiro.

#### TabuleiroProxySecurity (Validador)

- Atua como um proxy de Proteção para validações, garantindo que as operações no tabuleiro sejam realizadas apenas em condições válidas.

#### Diagrama Simplificado

```plantuml
@startuml
skinparam linetype ortho

class Tabuleiro {
    + inicializarCasas(int linhas, int colunas)
    + colocarPeca(Peca peca, Posicao posicao)
    + moverPeca(Posicao origem, Posicao destino)
    + RemoverPeca(Posicao posicao)
}

class TabuleiroProxySecurity {
    + inicializarCasas(int linhas, int colunas)
    + colocarPeca(Peca peca, Posicao posicao, Map<Posicao, Casa> casas)
    + moverPeca(Posicao origem, Posicao destino, Map<Posicao, Casa> casas)
    + removerPeca(Posicao posicao)
}

Tabuleiro --> TabuleiroProxySecurity : Delegação de validações
@enduml
