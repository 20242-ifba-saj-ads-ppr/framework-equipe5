# Façade

### Intenção -

- Fornecer uma interface unificada para um conjunto de interfaces em um subsistema.
- O Façade define uma interface de nível mais alto que torna o subsistema mais fácil de ser usado.

### Motivação

- No framework, a classe `Tabuleiro` atua como um Façade, fornecendo uma interface simplificada para gerenciar o estado do tabuleiro e interagir com peças, casas e validações.
- Ela delega responsabilidades específicas, como validações, para outras classes (ex.: `TabuleiroProxySecurity`), escondendo a complexidade do subsistema.

#### Sem o Façade

- Sem o Façade, as classes que utilizam o tabuleiro precisariam interagir diretamente com suas dependências internas, como `Casa`, `Posicao` e `Peca`.
- Isso resultaria em um alto acoplamento e maior complexidade para os consumidores do subsistema.

#### Com o Façade

- Com o Façade, a classe `Tabuleiro` fornece métodos de alto nível, como `colocarPeca`, `moverPeca` e `removerPeca`, que encapsulam a lógica interna e delegam validações ao `TabuleiroProxySecurity`.
- Isso reduz o acoplamento e simplifica o uso do subsistema.
