package com.DAM1.Blackjack.participantes;
import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.juego.Configuracion;

import java.util.ArrayList;

public abstract class Participante {
    private final String nombre;
    private double saldo;
    private final ArrayList<Carta> cartas;
    private int sumaCartas;
    public Participante(String nombre) {
        this.nombre = nombre;
        saldo = Configuracion.getSaldoInicial();
        this.cartas = new ArrayList<>();
        this.sumaCartas = 0;
    }

    public boolean anyadirCarta(Carta carta){
        return cartas.add(carta);
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSumaCartas(int sumaCartas) {
        this.sumaCartas += sumaCartas;
    }

    public boolean addCarta(Carta c){
        this.setSumaCartas(c.getValorCarta());
        return cartas.add(c);
    }

    public abstract int estrategia(Participante p, Mazo m);

    public int getSumaCartas() {
        return sumaCartas;
    }

    public void resetearCartas() {
        cartas.clear();
    }

    @Override
    public String toString() {
        return "( nombre=" + nombre + ", saldo=" + saldo + " )";
    }

    public void getCartas() {
        for (Carta c: cartas) {
            System.out.println(c.print());
        }
    }

    public void setSalario(double cant) {
        this.saldo = cant;
    }
    public void restarSalario(int cant) {
        this.saldo -= cant;
    }

    
}