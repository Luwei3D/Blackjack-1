package com.DAM1.Blackjack.cartas;

public class Carta {
    /**
     * La clase `Carta` representa una carta de un mazo de cartas en el juego de Blackjack.
     */
    private enum TipoCarta {
        CORAZONES,DIAMANTES,PICAS,TREBOLES;
    }
    private final int numCarta;
    private TipoCarta tipo;
    private int valorCarta;
    /**
     * Constructor de la clase `Carta`.
     *
     * @param numCarta   Número de la carta.
     * @param tipoCarta  Tipo de la carta (Corazones, Diamantes, Picas, Treboles).
     */

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
    /**
     * Obtiene el número de la carta.
     *
     * @return Número de la carta.
     */

    public int getNumCarta() {
        return numCarta;
    }
    /**
     * Genera una representación visual de la carta.
     *
     * @return Representación visual de la carta.
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("┌──────────────").append("\n")
                .append("│"+this.numCarta+"             │").append("\n")
                .append("│              │").append("\n")
                .append("│              │").append("\n")
                .append("│   "+ this.tipo+"    ").append("\n")
                .append("│              │").append("\n")
                .append("│              │").append("\n")
                .append("│            "+this.numCarta +"").append("\n")
                .append("└──────────────┘").append("\n");
        return sb.toString();
    }
    /**
     * Obtiene el valor numérico de la carta.
     *
     * @return Valor numérico de la carta.
     */
    public int getValorCarta() {
        return valorCarta;
    }

}