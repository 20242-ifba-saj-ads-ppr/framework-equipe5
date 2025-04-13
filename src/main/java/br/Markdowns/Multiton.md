# Multiton
### Intenção-
variação do Singleton que permite que uma única classe possua instâncias limitadas de determinado objeto sendo ela possuidora de apenas um identificador.

### Motivação no contexto do Tabuleiro -
O multiton é usado para representar times no tabuleiro. Pode existir mais de um time, mas cada um é identificado de forma única.

### Participantes -
1.**Multiton:** representam os times Branco e Preto.
2. **Client:** Tabuleiro, Peca -> classes que utilizam as instâncias do multiton.

### UML sem multiton -
<img alt="Motivação sem multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\src\main\java\br\com\frameworkPpr\xadrez\multiton\motivacao_sem_multiton\motivacao_sem_multiton.png">

### UML com multiton -
<img alt="Motivação com multiton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\out\src\main\java\br\com\frameworkPpr\xadrez\multiton\motivacao_com_multiton\motivacao_com_multiton.png">