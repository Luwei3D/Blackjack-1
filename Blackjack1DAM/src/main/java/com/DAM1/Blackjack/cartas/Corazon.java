package com.DAM1.Blackjack.cartas;

public class Corazon extends Carta{
    private final String numeroCarta;
    public Corazon(int valor, String numeroCarta) {
        super(valor);
        this.numeroCarta = numeroCarta;
    }

    @Override
    public String toString() {
        return " "; //Aquí mostraremos la carta
    }
}
