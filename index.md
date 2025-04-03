---
export_on_save:
  html: true
---

# Multiton (não GoF)

[^K19]    

Permitir a criação de uma quantidade limitada de instâncias de determinada classe e fornecer um modo para recuperá-las.

## Intenção

Com o Multiton, podemos definir instancias de times em um jogo de tabuleiro 

## Motivação

Considere que em um jogo de Tabuleiro, precisamos criar uma representação dos times Preto e Branco. Naturalmente, uma possibilidade seria utilizar a estratégia de Maps para gerenciar cada tipo de time, nesse sentido, teriamos uma classe para gerencia - los o que se institui uma forma legitma, porem ineficiente, visto que, todo momento que quisessemos acessar uma informação referente ao time teriamos que chamar o map para retirar as infos.

<figure>

@include: ./src/main/java/br/com/frameworkPpr/xadrez/multiton/motivacao_sem_multiton.puml

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Multiton</figcaption>

</figure>

Podemos simplificar isso aplicando o multiton, com o uso dele declarado 2 instancias fixas para representar esses times, afim de serem usadas em diversas funcionalidades. Alem disso, é garantido que cada enum de time terá acesso excusivo a valores de atributos explicitos.

<figure>

@include: ./src/main/java/br/com/frameworkPpr/xadrez/multiton/motivacao_com_multiton.puml

<figcaption>Exemplo de como o Multiton Pode ser Aplicado</figcaption>
</figure>

## Estrutura

<figure>

@include: ./src/main/java/br/com/frameworkPpr/xadrez/multiton/time/estruturaTime.puml

<figcaption>Estrutura do Multiton</figcaption>

</figure>

## Participantes

- Enum time (Multiton) - Define duas instâncias de time (preto e branco);

## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.

[^K19]: KASPCHUK, Alexandre; PLEIN, Tiago. K19 - Design Patterns em Java. São Paulo: K19 Treinamentos, 2012.
