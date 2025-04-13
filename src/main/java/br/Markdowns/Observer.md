# Observer

### Intenção -
Permitir a definição de um mecanismo de assinatura para notificar múltiplos objetos sobre qualquer evento que aconteça com o objeto observado.

### Motivação no contexto do Tabuleiro -
O observer monitora o estado do jogo verificando se há um vencedor através o número de peças de cada time.

### Participantes -
1. **Subject:** Tabuleiro -> ele é o objeto observado e notifica os observadores sobre mudanças no estado do jogo;
2. **Observer:** VioriaDerrotaObserver -> define a interface para ser notificado sobre eventos no SUBJECT (*Tabuleiro*);
3. **ConcreteObserver:** VitoriaDerrotaObserver -> implementa o observer e reage as notificações do *Tabuleiro*. Ele declara o vencedor quando notificado pelo Tabuleiro, por exemplo.

### UML -
<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\src\main\java\br\com\frameworkPpr\GerenciadorVitoriaDerrota\estruturaVitoriaDerrotaObserver\estruturaVitoriaDerrotaObserver.png">

