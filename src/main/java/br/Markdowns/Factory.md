# Factory

### Intenção -
Fornecer uma interface para criação de objetos em uma superclasse porém as subclasses cotém permissão para alterar os tipos de objetos que serao criados.

### Motivação no contexto do tabuleiro -
Esse padrão é usado para criar instâncias de peças, ele encapsula a lógica da criação, permitindo que novas peças sejam adicionadas sem modificar o códifo existente. O método *criarPecaGenerica* permite a criação de peças com características personalizadas.

### Participantes -
1. **Produto:** Peca -> define a interface base para os objetos que serão criados;
2. **Factory:** PecaFactory -> contém o método responsável por criar as instâncias das peças.
3. **Client:** Tabuleiro -> classe que utiliza a fábrica para criar objetos.

### UML -
