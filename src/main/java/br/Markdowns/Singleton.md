# Singleton

### Intenção -
garantir que uma classe possua apenas uma isntância e provê um ponto de acesso global a ela.

### Motivação no contexto do Tabuleiro -
unicidade do tabuleiro já que ele é um recurso central e único, varias instâncias dele causaria inconsistência no estado do jogo. Com o acesso globaç, outras partes do sistema, peças, jogadores, regras... podem interagir de forma consistente. 

### Participantes -
1.  **Singelton:**
    representado pela classe **tabuleiro** através de uma construtor privado, um método estático getInstance() que retorna a instância única dessa classe.
2. **Client:**
   são as **peças**, **jogadores**, **regras do jogo**.

### UML sem singleton:
<img alt="Motivação sem Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\src\main\java\br\com\motivacao_sem_singleton.png">

### UML com singleton:
<img alt="Motivação com Singleton" src="C:\Users\Administrador\Documents\GitHub\framework-equipe5\src\main\java\br\com\frameworkPpr\xadrez\board\tabuleiro\singletonEProxySecurity\motivacao_com_singleton.png">






