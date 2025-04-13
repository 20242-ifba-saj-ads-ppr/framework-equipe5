# Proxy
### Intenção -
atuar como intermediário entre o cliente e um objeto real, controlando o acesso a ele.
### Morivação no Contexto do tabuleiro -
proteger o acesso ao tabuleiro e garantir que certas ações, como iniciar o jogo, sejam verificadas antes da execução.
ex: antes de colocar uma peça no tabuleiro, o método **colocarPeca** verifica se a posição é valida e se o jogo já foi iniciado.

### Participantes -
1. **Proxy:** TabuleiroProxySecurity -> ele atua como intermediário entre o cliente e o objeto real, que é o Tabuleiro;
2. **Objeto real:** Tabuleiro -> contém a lógica principal do jogo, como gerenciar casas, peças e as interações. O *TabuleiroProxySecurity* delega as operações ao *Tabuleiro* após realizar as validações necessárias.
3. **Cliente:** Peca, VitoriaDerrotaObserver -> classes que interagem com o abuleiro por meio do proxy.

### UML 

