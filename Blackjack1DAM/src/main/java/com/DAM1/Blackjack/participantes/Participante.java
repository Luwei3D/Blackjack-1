package com.DAM1.Blackjack.participantes;
import com.DAM1.Blackjack.cartas.Carta;
import com.DAM1.Blackjack.cartas.Mazo;
import com.DAM1.Blackjack.juego.Configuracion;

import java.util.ArrayList;

public abstract class Participante {
    private final String nombre;
    private int saldo;
    private final ArrayList<Carta> cartas;
    private int sumaCartas;
    public Participante(String nombre) {
        this.nombre = nombre;
        saldo = Configuracion.saldoInicial;
        this.cartas = new ArrayList<>();
    }

    public boolean anyadirCarta(Carta carta){
        return cartas.add(carta);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSumaCartas(int sumaCartas) {
        this.sumaCartas += sumaCartas;
    }

    public boolean addCarta(Carta c){
        return cartas.add(c);
    }

    public abstract int estrategia(Participante p, Mazo m);

    public int getSumaCartas() {
        return sumaCartas;
    }
}
