package com.DAM1.Blackjack.juego;

public class Historico {
    private int id;
    private final String victorioso;
    private final String [] participantes;
    private int contador = 0;

    public int getId() {
        return id;
    }

    public String getGanador() {
        return victorioso;
    }

    public String[] getParticipantes() {
        return participantes;
    }

    public Historico(String victorioso, String[] participantes) {
        this.id = ++contador;
        this.victorioso = victorioso;
        this.participantes = participantes;
    }
}

