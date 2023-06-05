package com.DAM1.Blackjack.participantes.cpu;

import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.juego.Comprobacion;
import com.DAM1.Blackjack.juego.Situacion;
import com.DAM1.Blackjack.juego.TipoCPU;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.cartas.Carta;
import java.util.Random;

public class Banco extends Participante{

    private static final int LIMITE_PASIVO = 16;

    private static final int LIMITE_AGRESIVO = 20;
    private Random random = new Random();
    private TipoCPU tipoCPU;

    public Banco(String nombre) {
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
     * Método de interfaz la cual depende del bot 
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
     * Se realiza la jugada de cojer una carta y depende del tipo de bot que hayamos creado cojeremos hasta un cierto límite
     * @param p
     * @param m
     * @param limite
     * @return
     */
    private Situacion jugada(Participante p, Mazo m, int limite){
        Situacion situacion;
        do {
            Carta carta = m.sacarCarta();
            p.addCarta(carta);
            p.setSumaCartas(carta.getNumCarta());
            situacion = Comprobacion.carta(p);
            switch (situacion){
                case BLACKJACK:
                    return Situacion.BLACKJACK;
                case MAS_LIMITE:
                    return Situacion.MAS_LIMITE;
                default:
                    break;
            }
        }while (p.getSumaCartas() <= limite);
        return Situacion.MENOS_LIMITE;
    }


}