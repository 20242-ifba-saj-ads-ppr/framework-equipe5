# Strategy 
### Intenção -
Definir uma família de algoritmos em classes separadas para que seus objetos sejam intercambiáveis. 

### Motivação no contexto do Tabuleiro -
O strategy é usado nesse constexto para definir diferentes estratégias de movimento para as peças. Cada peça pode ter sua própria lógica de movimento. A interface *MovimentoStrategy* define o método *calcularMovimentosPossiveis* que é implementado por classes específicas para cada tió de peça.

### Participantes -
1. **Strategy:** MovimentoStrategy -> declara o método calcularMovimentosPossiveis que é implementado por diferentes estratégias;
2. **ConcretStrategy:** serão os métodos que implementam a interace MovimentoStrategy que criarão a lógica específica de cada peça;
3. **Context:** Peca -> contém a referência para um objeto MovimentoStrategy, delega a execução do método *calcularMovimentosPossiveis* para a estratégia associada (ConcretStrategy).

### UML -

