package com.DAM1.Blackjack.participantes.cpu;

import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;

public interface Estrategico {

    /**
     * Estrategia que implementarán los participantes, cada uno a su manera para ser o mas pasivo o agresivos
     * @param p participantes sobre los que se actuara
     * @param m y el mazo de donde tendremos la puntuacion de las cartas
     * @return devolverá un int depeniendo su respuesta
     */
    public int estrategia(Participante p, Mazo m);
}
