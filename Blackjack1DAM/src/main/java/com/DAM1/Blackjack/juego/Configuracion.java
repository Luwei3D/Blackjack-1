package com.DAM1.Blackjack.juego;

import com.DAM1.Blackjack.utils.IO;

public class Configuracion {
    private static int saldoInicial = 15;
    private static int apuestaBase;

    private static int cantidad = 5;
    private static int saldoBanca =2 * apuestaBase * cantidad;

    public static int getSaldoInicial() {
        return saldoInicial;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public void setCantJugador(int nuevoNumJugador){
        cantidad=nuevoNumJugador;
    }
    public void setApuestaBase(int minimo){
        apuestaBase=minimo;


    }
    public void setSaldoInicial(int nuevoSaldo){
        saldoInicial=nuevoSaldo;
    }
    public void setSaldoBanca(int nuevoSaldoBanca){
        saldoBanca=nuevoSaldoBanca;

    }
}