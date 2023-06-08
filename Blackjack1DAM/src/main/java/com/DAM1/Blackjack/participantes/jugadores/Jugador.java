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

    /**
     * Estrategia que hereda de Participante y aplica la estrategia para el Jugador. Solicita si quiere nuevas cartas,
     * en caso afirmativo, la anyade, la enseya y comprueba su situación para ver si se ha pasado o ha hecho blackjack
     * @param p Participantes sobre los que se actuará
     * @param m mazo de donde se sacarán todas las cartas
     * @return
     */
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
                    carta.print();
                    p.addCarta(carta);
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