package com.DAM1.Blackjack.cartas;
/**
 * La clase `Baraja` representa una baraja de cartas en el juego de Blackjack.
 */

public class Baraja {
    private static final int MAX_BARAJA = 52;
    private static final int MAX_CARTAS = 13;
    private final Carta[] cartas;
    /**
     * Crea una nueva instancia de la clase `Baraja` y inicializa la baraja de cartas.
     */

    public Baraja() {
        cartas = new Carta[MAX_BARAJA];
        this.anyadirCartas();
    }
    /**
     * Añade todas las cartas a la baraja.
     */

    private void anyadirCartas() {
        int k = 0;
        String[] tipoCartas = {"Corazones", "Treboles", "Picas", "Diamantes"};
        do {
            for (int i = 0; i < tipoCartas.length; i++) {
                int l = 0;
                for (int j = 0; j < MAX_CARTAS; j++) {
                    l = j+1;
                    if (j != 1) {
                        switch (tipoCartas[i]) {
                            case "Corazones":
                                cartas[k] = new Carta(l, "Corazones");
                                break;
                            case "Treboles":
                                cartas[k] = new Carta(l, "Treboles");
                                break;
                            case "Picas":
                                cartas[k] = new Carta(l, "Picas");
                                break;
                            case "Diamantes":
                                cartas[k] = new Carta(l, "Diamantes");
                                break;
                        }
                        k++;
                    }
                }
            }
        } while (k > MAX_BARAJA);
    }
    /**
     * Obtiene todas las cartas de la baraja.
     *
     * @return Un array de objetos `Carta` que representa todas las cartas de la baraja.
     */


    public Carta[] getCartas() {
        return cartas;
    }
}
