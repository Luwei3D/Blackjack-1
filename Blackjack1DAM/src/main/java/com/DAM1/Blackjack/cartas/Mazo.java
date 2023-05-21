package com.DAM1.Blackjack.cartas;

import java.util.Random;

public class Mazo {

    private final Carta[] mazo;

    public Mazo(Baraja baraja) {
        this.mazo = crearMazo(baraja);
    }



    private Carta[] crearMazo(Baraja baraja){
        Random random = new Random();
        Carta[] cartas = baraja.getCartas();
        int longCartas = cartas.length-1;
        for (int i = 0; i < cartas.length; i++){
            int pos = random.nextInt(cartas.length + 1);
            mezcla(cartas, pos, longCartas);
            longCartas--;
        }
        return cartas;
    }


    private void mezcla(Carta[] array, int origen, int destino){
        Carta auxiliar = array[origen];
        array[origen] = array[destino];
        array[destino] = auxiliar;
    }


}
