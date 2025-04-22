package main.java.br.com.frameworkPpr.boardgame.padroes.comportamentais.observer;

import main.java.br.com.frameworkPpr.boardgame.padroes.criacionais.multiton.Time;

//regras para vitoria e derrota personalizável 
public interface CondicaoDeVitoria {
    Time verificarVencedor();
}
