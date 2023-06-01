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

    private Mazo mazo;
    private Baraja baraja;
    private final Participante[] participantes;
    private Participante victorioso;
    
    public Game(Participante[] participantes) {
        //Control de la creación de los jugadores
        this.participantes = participantes;
        System.out.println("Mostrando participantes...");
        pause();
        System.out.println(this.getParticipantes());
        ronda();
    }

    public void ronda(){
        baraja = new Baraja();
        mazo = new Mazo(baraja);

        for (Participante p: participantes){
            repartoCartas(p);
        }

        Participante[] noVictoriosos = new Participante[participantes.length];
        int i = 0;

        //Se solicita si quiere una nueva carta
        for (Participante p: participantes){
            int estrategia = p.estrategia(p, mazo);
            if (estrategia == 0){
                System.out.println(p.getNombre() + " HA GANADO!");
                this.victorioso = p;
                break;
            } else if (estrategia == 1) {
                System.out.println(p.getNombre() + " se ha pasado de 21");
            } else {
                noVictoriosos[i] = p;
                i++;
            }
        }

        if (noVictoriosos.length != 0){
            Participante p = Comprobacion.ganador(noVictoriosos);
            System.out.println(p.getNombre() + " HA GANADO!");
            this.victorioso = p;
        }
    }

    protected String getParticipantes() {
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

    public Participante getVictorioso() {
        return victorioso;
    }
}
