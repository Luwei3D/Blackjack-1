package com.DAM1.Blackjack.participantes.cpu;

import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;

public interface Estrategico {
    public int estrategia(Participante p, Mazo m);
}
