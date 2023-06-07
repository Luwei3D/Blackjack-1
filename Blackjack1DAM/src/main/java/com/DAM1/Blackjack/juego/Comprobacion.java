package com.DAM1.Blackjack.juego;

import java.util.ArrayList;

import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;

public class Comprobacion {
    /**
     * Comprueba si el salario de jugador esta menor que zero
     * @param jugador recibe uno de los jugadores
     * @return devuelve false o true dependiendo de si es mayo o memor que zero
     */
    public static boolean salario(Jugador jugador){
        if (jugador.getSaldo() <= 0){
            return false;
        }
        return true;
    }

    /**
     * Comprueba si el salario de jugador esta menor que zero
     * @param bot recibe uno de los bots
     * @return devuelve false o true dependiendo de si es mayo o memor que zero
     */
    public static boolean salario(Bot bot){
        if (bot.getSaldo() <=0){
            return false;
        }
        return true;
    }

    /**
     * Comprueba si la suma de las cartas es mayor o menor que zero
     * o si es blackjack
     * @param participante uno de los participantes activos del jeugo
     * @return devuelve un enumerado que indica el estado
     */
    public static Situacion carta(Participante participante){
        if (participante.getSumaCartas() < 21){
            return Situacion.MENOS_LIMITE;
        } else if (participante.getSumaCartas() > 21) {
            return Situacion.MAS_LIMITE;
        }
        return Situacion.BLACKJACK;
    }

    /**
     * Comprueba la position del ganador
     * @param participantes del arraylist
     * @return la posicion del gandor
     */
    public static Participante ganador(ArrayList<Participante> participantes){
        int valor = Integer.MIN_VALUE;
        int posGanador = 0;
        for (int i = 0; i < participantes.size(); i++){
            if (participantes.get(i).getSumaCartas() > valor){
                posGanador = i;
                valor = participantes.get(i).getSumaCartas();
            }
        }
        return participantes.get(posGanador);
    }
}