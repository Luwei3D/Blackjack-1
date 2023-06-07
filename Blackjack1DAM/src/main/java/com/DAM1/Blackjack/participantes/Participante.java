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

    /**
     * Cuando se le llame, nayade una carta al arraylist de carta.
     * @param carta Carta que se le pasa como atributo para anyadirla al arraylist
     * @return devuelve true o false dependiendo si se ha anyadido
     */
    public boolean anyadirCarta(Carta carta){
        return cartas.add(carta);
    }

    /**
     * Devuelve el nombre del participante
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el saldo del participante
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Setter para poder sumar las cartas, cada vez que se llama al metodo se suma ella misma mas la que se
     * le pase
     * @param sumaCartas
     */

    public void setSumaCartas(int sumaCartas) {
        this.sumaCartas += sumaCartas;
    }

    /**
     * Anyade carta primero sumando el valor de esta y luego se le anyade al arraylist de cartas
     * @param c carta que se le pasa para anyadir.
     * @return
     */

    public boolean addCarta(Carta c){
        this.setSumaCartas(c.getValorCarta());
        return cartas.add(c);
    }

    /**
     * Clase abstracta que implementaran todos los participantes dependiendo lo que hagan
     * @param p
     * @param m
     * @return
     */
    public abstract int estrategia(Participante p, Mazo m);

    /**
     * Devuelve el valor de suma cartas
     * @return
     */
    public int getSumaCartas() {
        return sumaCartas;
    }

    /**
     * Resetea por completo el arraylist de cartas
     */
    public void resetearCartas() {
        cartas.clear();
    }

    /**
     * Convierte a String el nombre y el saldo
     * @return
     */
    @Override
    public String toString() {
        return "( nombre=" + nombre + ", saldo=" + saldo + " )";
    }

    /**
     * Devuelve el arraylist de cartas y lo muestra por pantalla
     */
    public void getCartas() {
        for (Carta c: cartas) {
            System.out.println(c.print());
        }
    }

    /**
     * Aplica el salario pasado como parametro al salario del participante
     * @param cant
     */
    public void setSalario(double cant) {
        this.saldo = cant;
    }

    /**
     * Vacia el salario del participante lo que se quiera a través del parametro
     * @param cant
     */
    public void restarSalario(int cant) {
        this.saldo -= cant;
    }

    
}