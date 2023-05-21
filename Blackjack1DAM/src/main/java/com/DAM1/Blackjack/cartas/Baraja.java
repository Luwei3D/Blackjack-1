package com.DAM1.Blackjack.cartas;

public class Baraja {
    private static final int MAX_BARAJA = 52;
    private static final int MAX_CARTAS = 13;
    private final Carta[] cartas;

    public Baraja() {
        cartas = new Carta[MAX_BARAJA];
        this.anyadirCartas();
    }

    private void anyadirCartas() {
        int k = 0;
        String[] tipoCartas = {"Corazones", "Treboles", "Picas", "Diamantes"};
        do {
            for (int i = 0; i < tipoCartas.length; i++) {
                for (int j = 0; j < MAX_CARTAS; j++) {
                    switch (tipoCartas[i]) {
                        case "Corazones":
                            cartas[k] = new Carta(j++, "Corazones");
                            break;
                        case "Treboles":
                            cartas[k] = new Carta(j++, "Treboles");
                            break;
                        case "Picas":
                            cartas[k] = new Carta(j++, "Picas");
                            break;
                        case "Diamantes":
                            cartas[k] = new Carta(j++, "Diamantes");
                            break;
                    }
                }
            }
            k++;
        } while (k > MAX_BARAJA);
    }

    public Carta[] getCartas() {
        return cartas;
    }
}
