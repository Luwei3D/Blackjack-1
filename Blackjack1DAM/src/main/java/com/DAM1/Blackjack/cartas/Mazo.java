package com.DAM1.Blackjack.cartas;

import java.util.Random;

public class Mazo {



    private final Carta[] mazo;
    private int cont;
    private static final Random RANDOM = new Random();

    public Mazo(Baraja baraja) {
        this.mazo = crearMazo(baraja);
        cont = this.mazo.length - 1;
    }

    private Carta[] crearMazo(Baraja baraja){

        Carta[] cartas = baraja.getCartas();
        int longCartas = cartas.length-1;
        for (int i = 0; i < cartas.length; i++){
            int pos = RANDOM.nextInt(cartas.length + 1);
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

    public Carta sacarCarta(){

        int pos = RANDOM.nextInt(cont+1);
        Carta value = mazo[pos];
        change(mazo, pos, cont);
        cont--;

        return value;
    }

    private static void change(Carta[] array, int indiceOrigen, int indiceDestino) {
        Carta auxiliar = array[indiceOrigen];
        array[indiceOrigen] = array[indiceDestino];
        array[indiceDestino] = auxiliar;
    }

    public int getCont() {
        return cont;
    }

    public Carta[] getMazo() {
        return mazo;
    }
}
