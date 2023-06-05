package com.DAM1.Blackjack;
import com.DAM1.Blackjack.juego.Configuracion;
import com.DAM1.Blackjack.juego.Game;
import com.DAM1.Blackjack.juego.HistoricoPartidas;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Banco;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;
import com.DAM1.Blackjack.utils.IO;
import com.DAM1.Blackjack.participantes.cpu.Bot;

import java.util.Scanner;
/**
 * La clase `Main` es la clase principal que contiene el método `main` y controla la ejecución del juego de Blackjack.
 */
public class Main {
    private static int saldoBanca;
    private static int saldoJugador;
    private static int apuesta;
    private static Participante[] jugadores;
    private static Game game;
    private static Configuracion configuracion;
    private static HistoricoPartidas historicoPartidas;
    public static void main(String[] args) {
        configuracion = new Configuracion();
        historicoPartidas = new HistoricoPartidas();


        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    nuevaPartida();
                    break;
                case 2:
                    mostrarEstadisticas();

                    break;
                case 3:
                    mostrarMenuConfiguracion(scanner);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }


    /**
     * Muestra el menú principal del juego.
     */

    private static void mostrarMenuPrincipal() {
        System.out.println("***********************");
        System.out.println("***** BLACKJACK ******");
        System.out.println("***********************");
        System.out.println("1. Nueva partida");
        System.out.println("2. Mostrar estadísticas");
        System.out.println("3. Configuración");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    /**
     * Inicia una nueva partida del juego.
     */

    private static void nuevaPartida() {
        boolean continuar;
        int numBots = IO.readNumber("¿Cuantos bots quieres?", 0,Configuracion.getCantidad()-1);
        jugadores= new Participante[Configuracion.getCantidad()];
        for (int i = 0 ; i < Configuracion.getCantidad()-1 ; i++) {
            int l = i+1;
            if (i <= (Configuracion.getCantidad()-1)-numBots) {
                jugadores[i]=new Jugador(IO.readMessage("escribe el nombre del jugador " + l + " : ",1));
            } else {
                jugadores[i]=new Bot("Bot " + l);
            }
        }
        Banco banco =new Banco("Cruppier");
        jugadores[Configuracion.getCantidad()-1] = banco;
        do {
            game = new Game(jugadores);
            historicoPartidas.anyadirJuego(game);
            continuar = false;
            char cont = IO.readChar("Quieres continuar?(Y/N)", 0);
            if (cont == 'Y') {
                continuar = true;
                for (Participante p: jugadores) {
                    p.resetearCartas();
                }
            }
        }while(continuar);
    }

    /**
     * Muestra las estadísticas del juego.
     */
    private static void mostrarEstadisticas() {
        System.out.println(historicoPartidas.getNumManosGanados());
    }
    /**
     * Muestra el menú de configuración del juego.
     *
     * @param scanner Objeto `Scanner` utilizado para leer la entrada del usuario.
     */

    private static void mostrarMenuConfiguracion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("***********************");
            System.out.println("*** CONFIGURACIÓN ****");
            System.out.println("***********************");
            System.out.println("1. Cambiar número de jugadores");
            System.out.println("2. Cambiar la apuesta base");
            System.out.println("3. Cambiar el saldo inicial de los jugadores");
            System.out.println("4. Cambiar el saldo inicial de la banca");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    cambiarNumeroJugadores();
                    break;
                case 2:
                    cambiarApuestaBase();
                    break;
                case 3:
                    cambiarSaldoInicialJugadores();
                    break;
                case 4:
                    cambiarSaldoInicialBanca();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Cambia el número de jugadores.
     */

    private static void cambiarNumeroJugadores() {

        int numJugadores = IO.readNumber("Cuantos Jugadores quieres: ",1);
        configuracion.setCantJugador(numJugadores);

    }
    /**
     * Cambia la apuesta base.
     */
    private static void cambiarApuestaBase() {
        int nuevaApuesta = IO.readNumber("Ingrese la nueva apuesta base de los jugadores: ",1);
        configuracion.setApuestaBase(nuevaApuesta);
    }
    /**
     * Cambia el saldo inicial de los jugadores.
     */

    private static void cambiarSaldoInicialJugadores() {
        int nuevoSaldoJugadores = IO.readNumber("Ingrese el nuevo saldo inicial de los jugadores: ",1);
        configuracion.setSaldoInicial(nuevoSaldoJugadores);

    }
    /**
     * Cambia el saldo inicial de la banca.
     */

    private static void cambiarSaldoInicialBanca() {
        int nuevoSaldoBanca = IO.readNumber("Ingrese el nuevo saldo inicial de los jugadores: ",1);
        configuracion.setSaldoBanca(nuevoSaldoBanca);

    }
}
