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
    protected String JugadorConMasVictorias(){
        int ganador = 0;
        int counterOfGanador = Integer.MIN_VALUE;
        int counter;
        StringBuilder sb = new StringBuilder();
        if(historico.size() > 0){
            for(int i = 0; i < historico.size();i++){
                counter = 0;
                for (int j = 0; j < historico.size();j++ ){
                    if(historico.get(i).getGanador().equalsIgnoreCase(historico.get(j).getGanador())){
                        counter++;
                    }
                }
                if(counter > counterOfGanador){
                    ganador = historico.get(i).getId();
                    counterOfGanador = ganador;
                }
            }
            sb.append(historico.get(ganador).getGanador());
        }else
            sb.append("El historico esta vacio");
        return sb.toString();
    }
    protected String JugadorConMenosVictorias(){
        int ganador = 0;
        int counterOfGanador = Integer.MAX_VALUE;
        int counter;
        StringBuilder sb = new StringBuilder();
        if(historico.size() > 0){
            for(int i = 0; i < historico.size();i++){
                counter = 0;
                for (int j = 0; j < historico.size();j++ ){
                    if(historico.get(i).getGanador().equalsIgnoreCase(historico.get(j).getGanador())){
                        counter++;
                    }
                }
                if(counter < counterOfGanador){
                    ganador = historico.get(i).getId();
                    counterOfGanador = counter;
                }
            }
            sb.append(historico.get(ganador).getGanador());
        }else
            sb.append("El historico esta vacio");
        return sb.toString();
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
