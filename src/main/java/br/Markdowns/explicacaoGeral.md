1 - Uso do Padrão Singleton:
(classe Tabuleiro)
-> Esse padrão é usado para garantir que exista apenas uma instância do tabuleiro.
Tabuleiro possui um construtor privado e um método estático getInstance() que cria uma instância única da classe.

2 - Uso do Padrão Proxy:
(TabuleiroProxySecurity)
-> antes de realizar qualquer operação no tabuleiro, esse padrãp adiciona uma validação. Isso proteje o acesso ao tabuleiro garantindo que condições sejam verificadas antes de executar uma ação.
(por ex: verificar se uma posição é valida ANTES de mover a peça).

3 - Uso do Padrão Multiton:
(Time)
-> É usado para criar um número limitado de instâncias de uma classe. Nesse contexto, do tabuleiro, ele é usado para representar dois times - Branco e Preto.
A classe Time é implementada como um enum;

4 - Uso do Padrão Factory:
(Classe PecaFactory)
-> Esse padrão é usado para criar instâncias de peças de tabuleiro. Ele encapsula a lógica de criação e isso permite que novas peças sejam adiconadas SEM modificar o código que já existe.
No método criarPecaGenerica, há a criação de peças com caracterisícas personalizadas.

5- Uso do Padrão Strategy:
(MovimentoStrategy)
-> ele é usado para definir diferentes estratégiass de movimento para as peças do tabuleiro. Cada peça pode ter sua própria lógica de movimento.
A classe calcularMovimentosPossiveis é implementado por classes específicas que definem características da peça.

6 - Uso do Padrão Observer:
-> ele é utilizado para deinição de diferentes codições de vitória ou derrota, a classe CondicaoVitoria, por exemplo, permite implementar diferentes regras para determinação de um vencedor.


