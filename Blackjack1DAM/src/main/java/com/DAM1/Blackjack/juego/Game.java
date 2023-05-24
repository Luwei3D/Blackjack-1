package com.DAM1.Blackjack.juego;

import com.DAM1.Blackjack.cartas.Baraja;
import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Banco;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;
import com.DAM1.Blackjack.utils.IO;

public class Game {

    private final Mazo mazo;
    private final Participante[] participantes;
    private Participante victorioso;
    
    public Game(Participante[] participantes) {
        //Control de la creación de los jugadores
        this.participantes = participantes;
        System.out.println("Mostrando participantes...");
        pause();
        System.out.println(this.getParticipantes());
        Baraja baraja = new Baraja();
        for (Participante p: participantes) {
            if (p instanceof Banco) {
                Participante banco = new Banco(p.getNombre());
                break;
            }
        }

        mazo = new Mazo(baraja);

        for (Participante p: participantes){
            repartoCartas(p);
        }

        //Se solicita si quiere una nueva carta
        for (Participante p: participantes){
            p.estrategia(p, mazo);
        }

    }

    private String getParticipantes() {
        StringBuilder sb = new StringBuilder();
        for (Participante j: participantes) {
            sb.append(j.toString());
        }
        return sb.toString();
    }
    private static void pause() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }


    private boolean repartoCartas(Participante p){

        int cont = 0;
        do {
            if (p instanceof Jugador || p instanceof Bot){
                cont = -1;
            }
            Carta cartaDevuelta = mazo.sacarCarta();
            //Imprimir Carta
            p.addCarta(cartaDevuelta);
            cont++;
        }while (cont < 1);

        return true;
    }
}
