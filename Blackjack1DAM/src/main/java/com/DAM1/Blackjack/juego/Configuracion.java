package com.DAM1.Blackjack.juego;


public class Configuracion {
    private static int saldoInicial = 15;
    private static int apuestaBase = 5;

    private static int cantidad = 5;
    private static int saldoBanca =2 * apuestaBase * cantidad;

    public static int getSaldoInicial() {
        return saldoInicial;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static int getApuestaBase() {
        return apuestaBase;
    }


    /**
     * Establece la cantidad de jugadores.
     *
     * @param nuevoNumJugador Nuevo número de jugadores.
     */
    public void setCantJugador(int nuevoNumJugador){
        cantidad=nuevoNumJugador;
    }

    /**
     * Establece la apuesta base.
     *
     * @param minimo Nuevo valor mínimo para la apuesta base.
     */
    public void setApuestaBase(int minimo){
        apuestaBase=minimo;
    }
    /**
     * Establece el saldo inicial para los jugadores.
     *
     * @param nuevoSaldo Nuevo saldo inicial para los jugadores.
     */
    public void setSaldoInicial(int nuevoSaldo){
        saldoInicial=nuevoSaldo;
    }
    /**
     * Establece el saldo de la banca.
     *
     * @param nuevoSaldoBanca Nuevo saldo para la banca en caso de que mayor a saldoBanca.
     */
    public void setSaldoBanca(int nuevoSaldoBanca){
        if (nuevoSaldoBanca >= saldoBanca) {
            saldoBanca=nuevoSaldoBanca;
        }
    }
}