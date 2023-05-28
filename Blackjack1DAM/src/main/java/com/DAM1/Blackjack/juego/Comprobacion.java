package com.DAM1.Blackjack.juego;

import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;

public class Comprobacion {

    public static boolean salario(Jugador jugador){
        if (jugador.getSaldo() <= 0){
            return false;
        }
        return true;
    }

    public static boolean salario(Bot bot){
        if (bot.getSaldo() <=0){
            return false;
        }
        return true;
    }

    public static Situacion carta(Participante participante){
        if (participante.getSumaCartas() < 21){
            return Situacion.MENOS_LIMITE;
        } else if (participante.getSumaCartas() > 21) {
            return Situacion.MAS_LIMITE;
        }
        return Situacion.BLACKJACK;
    }

    public static Participante ganador(Participante[] participantes){

        int valor = Integer.MIN_VALUE;
        int posGanador = 0;
        for (int i = 0; i < participantes.length; i++){
            if (participantes[i].getSumaCartas() > valor){
                posGanador = i;
                valor = participantes[i].getSumaCartas();
            }
        }
        return participantes[posGanador];
    }
}
