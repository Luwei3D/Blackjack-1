package com.DAM1.Blackjack.participantes.jugadores;


import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.juego.Comprobacion;
import com.DAM1.Blackjack.juego.Situacion;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Estrategico;
import com.DAM1.Blackjack.utils.IO;

import java.util.ArrayList;

public class Jugador extends Participante {

    public Jugador(String nombre) {
        super(nombre);
    }

    @Override
    public int estrategia(Participante p, Mazo m) {
            String respuesta;
            Situacion situacion;
            do {
                char c = IO.readChar("Quieres nueva carta? (S/N) ", 1);
                respuesta = Character.toString(c).toUpperCase();
                if (respuesta.equals("S")){
                    Carta carta = m.sacarCarta();
                    System.out.println(carta.print());
                    p.addCarta(m.sacarCarta());
                    situacion = Comprobacion.carta(p);
                    switch (situacion){
                        case BLACKJACK:
                            return 0;
                        case MAS_LIMITE:
                            return 1;
                    }
                }

            }while (respuesta.equals("S"));
            return -1;
    }

}
