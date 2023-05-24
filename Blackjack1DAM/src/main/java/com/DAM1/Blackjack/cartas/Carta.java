package com.DAM1.Blackjack.cartas;

public class Carta {
    private enum TipoCarta {
        CORAZONES,DIAMANTES,PICAS,TREBOLES;
    }
    private int numCarta;
    private TipoCarta tipo; 

    public Carta(int numCarta, String tipoCarta) {
        this.numCarta = numCarta;
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



}
