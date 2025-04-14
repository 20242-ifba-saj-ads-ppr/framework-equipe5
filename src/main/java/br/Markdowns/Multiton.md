# Multiton (Não GOF)

### Intenção-

[^K19]    

Permitir a criação de uma quantidade limitada de instâncias de determinada classe e fornecer um modo para recuperá-las.

### Motivação no contexto do Tabuleiro -

- Com o Multiton, podemos definir instancias como identificação única para times em um jogo de tabuleiro: 
  
  - Considere que em um jogo de Tabuleiro, precisamos criar uma representação dos times Preto e Branco. Naturalmente, uma possibilidade seria utilizar a estratégia de Maps para gerenciar cada tipo de time, nesse sentido, teriamos uma classe para gerencia - los o que se institui uma forma legitma, porem ineficiente, visto que, todo momento que quisessemos acessar uma informação referente ao time teriamos que chamar o map para retirar as infos.


### Participantes -
1. **Multiton:** (Enum Time)  Define duas instâncias de time (preto e branco);
2. **Client:** (Tabuleiro), Peca -> classes que utilizam as instâncias do multiton.

### UML sem multiton -
<img alt="Motivação sem multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\src\main\java\br\com\frameworkPpr\xadrez\multiton\motivacao_sem_multiton\motivacao_sem_multiton.png">

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Multiton</figcaption>

### UML com multiton -
<img alt="Motivação com multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\src\main\java\br\com\frameworkPpr\xadrez\multiton\motivacao_com_multiton\motivacao_com_multiton.png">

<figcaption>Exemplo de como o Multiton Pode ser Aplicado</figcaption>

Podemos simplificar isso aplicando o multiton, com o uso dele declarado 2 instancias fixas para representar esses times, afim de serem usadas em diversas funcionalidades. Alem disso, é garantido que cada enum de time terá acesso excusivo a valores de atributos explicitos.
