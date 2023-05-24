package com.DAM1.Blackjack.participantes.jugadores;


import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Estrategico;
import com.DAM1.Blackjack.utils.IO;

import java.util.ArrayList;

public class Jugador extends Participante {

    public Jugador(String nombre) {
        super(nombre);
    }

    @Override
    public void estrategia(Participante p, Mazo m) {
            String respuesta;
            do {
                char c = IO.readChar("Quieres nueva carta? (S/N) ", 1);
                respuesta = Character.toString(c).toUpperCase();
                if (respuesta.equals("S")){
                    p.addCarta(m.sacarCarta());
                }
            }while (respuesta.equals("S"));
    }

}
