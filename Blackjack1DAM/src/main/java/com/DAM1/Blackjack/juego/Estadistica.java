package com.DAM1.Blackjack.juego;

import java.util.ArrayList;

public class Estadistica {
    private int numVicJug = 0;
    private int numVicCpu = 0;
    public int getNumVicJug() {
        return numVicJug;
    }
    public int getNumVicCPU() {
        return numVicCpu;
    }
    protected ArrayList<Historico> historico;
    protected String ganador;
    protected String [] participantes;
    private void addVicJug(Boolean manoGanado){
        if(manoGanado = false)
            numVicJug += +1;
    }
    private void addVicCpu(Boolean manoGanado){
        if(manoGanado = false)
            numVicCpu += +1;
    }

    public Estadistica() {
        historico = new ArrayList<>();
    }
    private void addGame(String ganador,String[] participantes,Boolean ganado){
        if(ganado = true)
            historico.add(new Historico(ganador,participantes));
    }


    @Override
    public String toString() {
        return "Estadistica{" +
                "jugador='" +
                " =" + numVicJug +
                ", cpu='" +
                ",=" + numVicCpu +
                '}';
    }

}
