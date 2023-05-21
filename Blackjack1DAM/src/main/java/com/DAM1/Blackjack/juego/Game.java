package com.DAM1.Blackjack.juego;

import com.DAM1.Blackjack.cartas.Baraja;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Banco;

public class Game {
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

        Mazo mazo = new Mazo(baraja);
        for (Participante p: participantes){

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
}
