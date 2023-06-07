package com.DAM1.Blackjack.juego;
import com.DAM1.Blackjack.participantes.cpu.Banco;
import com.DAM1.Blackjack.participantes.cpu.Bot;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;

import java.util.ArrayList;
public class HistoricoPartidas {
   private final ArrayList<Game> historico;

    /**
     * Creacion de arrayList vacio
     */
    public HistoricoPartidas() {
        this.historico = new ArrayList<>();
    }
    /**
     * Un booleano para anyadir nuevos 'juegos' o mejor
     * dicho partidas al arraylist
     * @param game que representa el juego vamos a anyadir
     * @return que anyade el juego
     */
    public boolean anyadirJuego(Game game){
        return historico.add(game);
    }
    /**
     * Este metodo muestro el numero de manos ganados que tiene el jugador y el cpu.
     * Hay 2 contadores que representan los manos ganados del cpu y jugador.
     * Un Stringbuiler que va a contener el resultado
     * Tambien en caso que el historico esta vaccio  va a aparecer el mensaje de que esta vaccio
     * Consiste en iterar el arraylist is usar instance of para determinar quien ha ganado y
     * aumentar el contador.
     * @return Devuelve el string con manos ganados o con mensaje de que esta vaccio el historico
     */
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
    /**
     * Este metodo muestra el participante con mas victorias usando un contador para cada tipo de participante
     * Usamos if para comprobar si el historico esta vaccio y en caso que hay partido dentro el arraylist
     * iteramos y usamos cominacion de if y instance of para determinar la cantidad de victorias de un participante.
     * Desoues del bucle usamos condicionales para deteminar quien ha ganado mas
     * @return Devuelve un string diciendo quien ha ganado mas
     */
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
    /**
     * Metodo para mostrar todas las partidas
     * @return devuelve un string con todas partidas
     */
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
    /**
     * Un metodo para imprimir las partidas ganadas de un participante especifico
     * El metodo recibe un string y despue usamos el switch para separar los participantes,
     * antes usamos un toLowerCase para poner las letras a minuscula,
     * en caso que el nombre no coincide sale mensaje de que este participante no existe
     * @param nombre de qparticipante cual qiures ver las victorias
     * @return el string con victorias o mensaje de error
     */
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
    /**
     * El metodo de imprimir
     * @return una string
     */
    @Override
    public String toString() {
        return "Historico{" +
                "historico=" + historico +
                '}';
    }
}