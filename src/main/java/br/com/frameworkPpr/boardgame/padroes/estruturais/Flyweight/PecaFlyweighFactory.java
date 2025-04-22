package main.java.br.com.frameworkPpr.boardgame.padroes.estruturais.flyweight;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class PecaFlyweighFactory {
    private static final Map<String, PecaFlyweight> pecas = new HashMap<>();

    public static PecaFlyweight getPeca(String tipo, Time time) {
        String key = tipo + "-" + time.toString();
        if (!pecas.containsKey(key)) {
            pecas.put(key, new PecaConcretaFlyweight(tipo, time));
        }
        return pecas.get(key);
    }

    public static int getTotalPecas()
    {
        return pecas.size();
    }
}
