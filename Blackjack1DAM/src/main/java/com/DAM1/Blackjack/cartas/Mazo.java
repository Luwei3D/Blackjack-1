package com.DAM1.Blackjack.cartas;

import java.util.Random;
/**
 * La clase `Mazo` representa un mazo de cartas utilizado en el juego de Blackjack.
 */

public class Mazo {
    private final Carta[] mazo;
    private int cont;
    /**
     * Crea una nueva instancia de la clase `Mazo` y construye el mazo utilizando la baraja especificada.
     *
     * @param baraja La baraja de cartas utilizada para construir el mazo.
     */

    public Mazo(Baraja baraja) {
        this.mazo = crearMazo(baraja);
        cont = mazo.length-1;
    }
    /**
     * Crea el mazo de cartas a partir de una baraja dada.
     *
     * @param baraja La baraja de cartas utilizada para construir el mazo.
     * @return Un array de objetos `Carta` que representa el mazo de cartas.
     */

    private Carta[] crearMazo(Baraja baraja){
        Random random = new Random();
        Carta[] cartas = baraja.getCartas();
        int longCartas = cartas.length-1;
        for (int i = 0; i < longCartas; i++){
            int pos = random.nextInt(longCartas+1);
            mezcla(cartas, pos, longCartas);
            longCartas--;
        }
        return cartas;
    }
    /**
     * Realiza una mezcla de cartas en el mazo.
     *
     * @param array   El array de cartas en el mazo.
     * @param origen  La posición de origen de la carta en el mazo.
     * @param destino La posición de destino de la carta en el mazo.
     */


    private void mezcla(Carta[] array, int origen, int destino){
        Carta auxiliar = array[origen];
        array[origen] = array[destino];
        array[destino] = auxiliar;
    }
    /**
     * Extrae una carta del mazo.
     *
     * @return La carta extraída del mazo.
     */

    public Carta sacarCarta(){
        Random random = new Random();
        Carta value;
        int pos = random.nextInt(cont);
        value = mazo[pos];
        change(mazo, pos, cont);
        cont--;
        return value;
    }
    /**
     * Intercambia la posición de dos cartas en el mazo.
     *
     * @param array         El array de cartas en el mazo.
     * @param indiceOrigen  La posición de origen de la carta en el mazo.
     * @param indiceDestino La posición de destino de la carta en el mazo.
     */

    private static void change(Carta[] array, int indiceOrigen, int indiceDestino) {
        Carta auxiliar = array[indiceOrigen];
        array[indiceOrigen] = array[indiceDestino];
        array[indiceDestino] = auxiliar;
    }
    /**
     * Obtiene el número de cartas restantes en el mazo.
     *
     * @return El número de cartas restantes en el mazo.
     */

    public int getCont() {
        return cont;
    }
    /**
     * Obtiene el mazo de cartas.
     *
     * @return Un array de objetos `Carta` que representa el mazo de cartas.
     */

    public Carta[] getMazo() {
        return mazo;
    }
}