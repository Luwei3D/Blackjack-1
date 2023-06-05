package com.DAM1.Blackjack.juego;

import com.DAM1.Blackjack.cartas.Baraja;
import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;
import com.DAM1.Blackjack.utils.IO;
import java.util.ArrayList;
public class Game {
    private Mazo mazo;
    private Baraja baraja;
    private final Participante[] participantes;
    private Participante victorioso;
    
    public Game(Participante[] participantes) {
        //Control de la creación de los jugadores
        this.participantes = participantes;
        this.baraja = new Baraja();
        ronda();
    }
    /**
     * Esto ejecuta una ronda
     */
    private void ronda(){
        System.out.println("Mostrando participantes...");
        pause();
        System.out.println(this.getParticipantes());
        mazo = new Mazo(this.baraja);
        System.out.println("Repartiendo cartas...");
        pause();
        for (Participante p: participantes){
            p.restarSalario(Configuracion.getApuestaBase());
            System.out.println("Reparto a " + p.getNombre());
            pause();
            repartoCartas(p);
        }
        ArrayList<Participante> noVictoriosos = new ArrayList<>(participantes.length); 
        //Se solicita si quiere una nueva carta
        for (Participante p: participantes){
            System.out.println("Turno de " + p.getNombre());
            int estrategia = p.estrategia(p, mazo);
            if (estrategia == 0){
                System.out.println(p.getNombre() + " ha hecho Blackjack!!");
                p.setSalario(p.getSaldo() + Configuracion.getApuestaBase()*1.5);
                this.victorioso = p;
                break;
            } else if (estrategia == 1) {
                System.out.println(p.getNombre() + " se ha pasado de 21!!");
            } else {
                noVictoriosos.add(p);
            }
        }
        if (this.victorioso == null){
            System.out.println("¿Quien será el ganador?...");
            pause();
            Participante p = Comprobacion.ganador(noVictoriosos);
            System.out.println(p.getNombre() + " HA GANADO!!");
            p.getCartas();
            p.setSalario(p.getSaldo() + Configuracion.getApuestaBase());
            this.victorioso = p;
        }
    }
    /**
     * Obtiene la lista de participantes
     * @return
     */
    protected String getParticipantes() {
        StringBuilder sb = new StringBuilder();
        for (Participante j: participantes) {
            sb.append(j.toString());
        }
        return sb.toString();
    }
    
    private static void pause() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    /**
     * Reparte las cartas. Si es un bot o un jugador, repartirán dos cartas donde ambas son visibles.<br>
     * Si en este caso es el cruppier, repartiran dos cartas también siendo visible una carta
     * @param p
     * @return
     */
    private boolean repartoCartas(Participante p){
        int cont = 0;
        if (p instanceof Jugador || p instanceof Bot){
            cont = -1;
        }
        do {
            Carta cartaDevuelta = mazo.sacarCarta();
            System.out.println(cartaDevuelta.print());
            p.addCarta(cartaDevuelta);
            cont++;
        }while (cont < 1);

        return true;
    }
    /**
     * Obtiene el victorioso de esa ronda
     * @return
     */
    public Participante getVictorioso() {
        return victorioso;
    }
}