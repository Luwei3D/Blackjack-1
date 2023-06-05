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
        
        for (int i = 0; i < tipoCartas.length; i++) {
            int l = 0;
            for (int j = 0; j < MAX_CARTAS; j++) {
                l = j+1;
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

    public Carta[] getCartas() {
        return cartas;
    }
}