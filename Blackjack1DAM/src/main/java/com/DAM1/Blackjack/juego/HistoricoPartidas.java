package com.DAM1.Blackjack.juego;
import com.DAM1.Blackjack.participantes.cpu.Banco;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;

import java.util.ArrayList;
public class HistoricoPartidas {
   private final ArrayList<Game> historico;
    public HistoricoPartidas() {
        this.historico = new ArrayList<>();
    }
    public boolean anyadirJuego(Game game){
        return historico.add(game);
    }
    public String getNumManosGanados(){
        StringBuilder sb = new StringBuilder();
        if(historico.isEmpty()){
            sb.append("El historico esta vaccio");
        }else{
            int ganadorJugador = 0;
            int ganadorCpu = 0;
            for (int i = 0; i < historico.size();i++){
                if(historico.get(i).getVictorioso() instanceof Jugador){
                    ganadorJugador += 1;
                }else
                    ganadorCpu += 1;
            }
            sb.append("El Jugadaor ha ganado ").append(ganadorJugador).append(" veces\n");
            sb.append("El Cpu ha ganado ").append(ganadorCpu).append(" veces\n");
        }
        return sb.toString();
    }
    public String quienHaGanadoMas(){
        StringBuilder sb = new StringBuilder();
        if(historico.isEmpty()){
            sb.append("El historico esta vaccio");
        }else{
            int ganadorJugador = 0;
            int ganadorCpu = 0;
            int ganadorBanco = 0;
            for (int i = 0; i < historico.size();i++){
                if(historico.get(i).getVictorioso() instanceof Jugador){
                    ganadorJugador += 1;
                }else if (historico.get(i).getVictorioso() instanceof Bot){
                    ganadorCpu += 1;
                }else if(historico.get(i).getVictorioso() instanceof Banco) {
                    ganadorBanco += 1;
                }
            }
            if(ganadorJugador > ganadorCpu && ganadorJugador > ganadorBanco){
                sb.append("El Jugador ha ganado mas que otros con " + ganadorJugador + " victorias ");
            }else if(ganadorBanco > ganadorJugador && ganadorBanco > ganadorCpu){
                sb.append("El Banco ha ganado mas que otros con " + ganadorBanco + " victorias ");
            }else
                sb.append("El bot ha ganado mas que otros con " + ganadorCpu + " victorias ");
        }
        return  sb.toString();
    }
    public String mostrarTodasPartidas(){
        StringBuilder sb = new StringBuilder();
        int id = 0;
        if(historico.isEmpty()){
            sb.append("El historico esta vacio");
        }else{
            for (int i = 0 ; i < historico.size();i++ ){
                ++id;
                sb.append(id).append(":").append("Ha ganado").append(historico.get(i).getVictorioso()).append(" y los participantes son").append(historico.get(i).getParticipantes());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String imprimirVictoriasDeParticipanteEspesifico(String nombre){
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        int id = 0;
        String participante = nombre.toLowerCase();
        if(historico.isEmpty()){
            sb.append("El historico esta vacio");
        }else{
            switch (participante) {
                case "jugador":
                    for (int i = 0; i < historico.size(); i++) {
                        ++id;
                        if (historico.get(i).getVictorioso() instanceof Jugador) {
                            sb.append(id).append(":").append("Ha ganado").append(historico.get(i).getVictorioso()).append(" y los participantes son").append(historico.get(i).getParticipantes());
                            cont++;
                        }
                    }
                    if (cont == 0)
                        sb.append("El jugador no tiene victorias");
                    break;
                case "bot":
                    for (int i = 0; i < historico.size(); i++) {
                        ++id;
                        if (historico.get(i).getVictorioso() instanceof Bot) {
                            sb.append(id).append(":").append("Ha ganado").append(historico.get(i).getVictorioso()).append(" y los participantes son").append(historico.get(i).getParticipantes());
                            cont++;
                        }
                    }
                    if (cont == 0)
                        sb.append("El bot no tiene victorias");
                    break;
                case "banco":
                    for (int i = 0; i < historico.size(); i++) {
                        ++id;
                        if (historico.get(i).getVictorioso() instanceof Banco) {
                            sb.append(id).append(":").append("Ha ganado").append(historico.get(i).getVictorioso()).append(" y los participantes son").append(historico.get(i).getParticipantes());
                            cont++;
                        }
                    }
                    if (cont == 0)
                        sb.append("El banco no tiene victorias");
                    break;
                default:
                    sb.append("El nombre introducido no coincide con ninguno de los participantes");
            }
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Historico{" +
                "historico=" + historico +
                '}';
    }
}