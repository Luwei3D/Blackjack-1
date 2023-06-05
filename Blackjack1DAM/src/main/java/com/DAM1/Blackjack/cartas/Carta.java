package com.DAM1.Blackjack.cartas;

public class Carta {
    private enum TipoCarta {
        CORAZONES,DIAMANTES,PICAS,TREBOLES;
    }
    private final int numCarta;
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
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("┌─────────────── ").append("\n")
                .append("│").append(this.numCarta).append('\t').append('\t').append('\t').append('\t').append("│").append("\n")
                .append("│").append('\t').append('\t').append('\t').append('\t').append("│").append("\n")
                .append("│").append('\t').append('\t').append('\t').append('\t').append("│").append("\n")
                .append("│").append('\t').append(this.tipo).append("   │").append("\n")
                .append("│").append('\t').append('\t').append('\t').append('\t').append("│").append("\n")
                .append("│").append('\t').append('\t').append('\t').append('\t').append("│").append("\n")
                .append("│").append('\t').append('\t').append('\t').append(this.numCarta).append("   │").append("\n")
                .append("└───────────────┘").append("\n");
        return sb.toString();
    }

    public int getValorCarta() {
        return valorCarta;
    }

}