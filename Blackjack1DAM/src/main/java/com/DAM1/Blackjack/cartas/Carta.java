package com.DAM1.Blackjack.cartas;

public class Carta {
    private enum TipoCarta {
        CORAZONES,DIAMANTES,PICAS,TREBOLES;
    }
    private int numCarta;
    private TipoCarta tipo; 
    private int valorCarta;

    public Carta(int numCarta, String tipoCarta) {
        this.numCarta = numCarta;
        if (numCarta > 10) {
            this.valorCarta = 10;
        } else if(numCarta == 1) {
            this.valorCarta = 11;
        } else {
            this.valorCarta = numCarta;
        }
        switch(tipoCarta) {
            case "Corazones":
                this.tipo = TipoCarta.CORAZONES;
                break; 
            case "Treboles":
                this.tipo = TipoCarta.TREBOLES;
                break;
            case "Picas":
                this.tipo = TipoCarta.PICAS;
                break;
            case "Diamantes":
                this.tipo = TipoCarta.DIAMANTES;
                break;
        }
    }

    public int getNumCarta() {
        return numCarta;
    }

}
