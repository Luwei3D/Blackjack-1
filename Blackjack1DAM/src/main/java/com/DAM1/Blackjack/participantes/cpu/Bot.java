package com.DAM1.Blackjack.participantes.cpu;

import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.juego.Comprobacion;
import com.DAM1.Blackjack.juego.Situacion;
import com.DAM1.Blackjack.juego.TipoCPU;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.utils.IO;

import java.util.Random;

public class Bot extends Participante{

    private static final int LIMITE_PASIVO = 16;

    private static final int LIMITE_AGRESIVO = 20;
    private Random random = new Random();
    private TipoCPU tipoCPU;

    public Bot(String nombre) {
        super(nombre);
        int i = random.nextInt(1-0+1)+0;
        switch(i) {
            case 0:
                this.tipoCPU = TipoCPU.AGRESIVO;
                break; 
            case 1: 
                this.tipoCPU = TipoCPU.PASIVO;
                break;
        };
    }

    /**
     * Hereda de participante su metodo estrategia, que dependiendo si es una CPU agresiva intentará llegar mas lejos,
     * en cambio si se trata de uno pasivo, se plantará antes.
     * @param p Se le pasa los participantes para saber la puntuacion de sus cartas
     * @param m y el mazo para poder pasarselo cuando se llame al metodo jugada
     * @return devuelve 0 en caso de blackjack, -1 en caso de que se plante o 1 en caso de que se pase.
     */
    @Override
    public int estrategia(Participante p, Mazo m) {
        int i = p.getSumaCartas();
        Situacion s = null;
        if (i <= 16){
            switch (tipoCPU){
                case PASIVO:
                    s = jugada(p, m, LIMITE_PASIVO);
                    break;
                case AGRESIVO:
                    s = jugada(p,m, LIMITE_AGRESIVO);
                    break;
            }
            switch (s){
                case BLACKJACK:
                    return 0;
                case MAS_LIMITE:
                    return 1;

            }
        }
        if (i == 21){
            return 0;
        }
        return -1;
    }

    /**
     * A través de un bucle va sacando cartas y anyadiendola al array de participantes. Luego comprueba dentro de
     * un swithc la situacion, si es jugada ganadora, se ha pasado o no ha llegado.
     * @param p se le pasan los participantes sobre los que itera
     * @param m el mazo donde va sacando cartas
     * @param limite y el limite de cartas
     * @return devuelve el tipo de situacion dependiendo
     */
    private Situacion jugada(Participante p, Mazo m, int limite){
        Situacion situacion;
        do {
            p.addCarta(m.sacarCarta());
            situacion = Comprobacion.carta(p);
            switch (situacion){
                case BLACKJACK:
                    return Situacion.BLACKJACK;
                case MAS_LIMITE:
                    return Situacion.MAS_LIMITE;
            }

        }while (p.getSumaCartas() <= limite);
        return Situacion.MENOS_LIMITE;
    }


}
