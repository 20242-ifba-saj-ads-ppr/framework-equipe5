---
export_on_save:
  html: true
---

# Decorator

[^GAMMA]    

Dinamicamente, agregar responsabilidades adicionais a um objeto. Os Decorators fornecem uma alternativa flexível ao uso de subclasses para extensão de funcionalidades.

## Intenção

Com o decorador, podemos adicionar funcionalidades a um objeto sem ter que alterar a classe do objeto.

## Também conhecido como

Wrapper

## Motivação

Considere que um desenvolvedor queira criar um jogo semelhante ao [Archero 2](https://play.google.com/store/apps/details?id=com.xq.archeroii&hl=pt_BR). Nesse tipo de jogo, o personagem pode ser equipado com vários itens, como armas, armaduras e acessórios. Esses itens são coletados durante a partida e podem ser usados para aumentar as habilidades do personagem. Cada novo item adiciona uma nova habilidade ao personagem sem remover as habilidades existentes, criando novas camadas de comportamento.

Sem a utilização do padrão Decorator, o desenvolvedor precisaria criar uma nova classe para cada combinação de habilidades que poderia ser utilizada pelo personagem. Isso pode levar a um número excessivo de classes e tornar o código mais difícil de manter.

<figure>

<!-- @include: ./src/motivacao_sem_padrao.puml -->

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Decorator</figcaption>

</figure>


O padrão Decorator permite que o desenvolvedor adicione novas funcionalidades a um objeto sem alterar sua classe. Isso é feito utilizando a composição e delegação, onde um objeto é composto por outros objetos e os métodos são delegados para os objetos compostos.

<figure>

<!-- @include: ./src/motivacao_com_padrao.puml -->


<figcaption>Exemplo de como o jogo pode ser implementado com o padrão Decorator</figcaption>
</figure>

Com essa nova implementação, o desenvolvedor pode adicionar novos itens ao jogo sem precisar criar novas classes para cada combinação de habilidades. Isso torna o código mais flexível e fácil de manter.

<!-- @include: ./src/motivacao_com_padrao.java -->


## Estrutura

<figure>

<!-- @include: ./src/estrutura.puml -->

<figcaption>Estrutura do Decorator</figcaption>

</figure>

## Participantes
- Component (Item)
  - define a interface para objetos que podem ter responsabilidades acrescenta das aos mesmos dinamicamente.
- ConcreteComponent (Arco) 
  - define um objeto para o qual responsabilidades adicionais podem ser atribuídas.
- Decorator (ItemDecorator)
  - mantém uma referência para um objeto Component e define uma interface que segue a interface de Component.
- ConcreteDecorator (Laser,Faca)
  - acrescenta responsabilidades ao componente.

## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.
