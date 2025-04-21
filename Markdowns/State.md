# Sate

### Intenção -
Permitir que um objeto altere seu comportamento quando seu estado interno muda. Ele encapsula os possíveis estados de um objeto em *classes separadas* promovendo a separação de responsabilidades.

### Motivação sem o padrão -
Sem a aplicação do pasrão o comportamento do objeto setia controlado por grandes estruturas de if-else ou switch-case que verificariam o estado atual pra decidir o que fazer. Toda lógica de estados estaria concentrada em apenas uma classe dificultando 

```java
// Exemplo sem o padrão State
public class Jogo {
    private String estado = "INICIADO";

    public void iniciarJogo() {
        if ("INICIADO".equals(estado)) {
            System.out.println("O jogo já está iniciado.");
        } else if ("PAUSADO".equals(estado)) {
            estado = "INICIADO";
            System.out.println("Jogo retomado.");
        } else if ("FINALIZADO".equals(estado)) {
            System.out.println("Não é possível iniciar, o jogo já foi finalizado.");
        }
    }

    public void pausarJogo() {
        if ("INICIADO".equals(estado)) {
            estado = "PAUSADO";
            System.out.println("Jogo pausado.");
        } else {
            System.out.println("Não é possível pausar neste estado: " + estado);
        }
    }

    public void finalizarJogo() {
        if (!"FINALIZADO".equals(estado)) {
            estado = "FINALIZADO";
            System.out.println("Jogo finalizado.");
        } else {
            System.out.println("O jogo já está finalizado.");
        }
    }
}
```

### uml sem o padrão

### Motivação com o Padrão - 