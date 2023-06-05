package com.DAM1.Blackjack;
import com.DAM1.Blackjack.juego.Configuracion;
import com.DAM1.Blackjack.juego.Game;
import com.DAM1.Blackjack.juego.HistoricoPartidas;
import com.DAM1.Blackjack.participantes.Participante;
import com.DAM1.Blackjack.participantes.cpu.Banco;
import com.DAM1.Blackjack.participantes.jugadores.Jugador;
import com.DAM1.Blackjack.utils.IO;

import java.util.Scanner;

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

    private static void nuevaPartida() {

        jugadores= new Participante[Configuracion.getCantidad()];
        for (int i = 0 ; i < Configuracion.getCantidad()-1 ; i++) {
            jugadores[i]=new Jugador(IO.readMessage("escribe el nombre del jugador " + i + " : ",1));
        }
        Banco banco =new Banco("Cruppier");
        jugadores[Configuracion.getCantidad()-1] = banco;
        game = new Game(jugadores);
    }

    private static void mostrarEstadisticas() {
        System.out.println(historicoPartidas.getNumManosGanados());
    }

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

    private static void cambiarNumeroJugadores() {

        int numJugadores = IO.readNumber("Cuantos Jugadores quieres: ",1);
        configuracion.setCantJugador(numJugadores);
        // Realizar la lógica para cambiar el número de jugadores
    }

    private static void cambiarApuestaBase() {
        int nuevaApuesta = IO.readNumber("Ingrese la nueva apuesta base de los jugadores: ",1);
        configuracion.setApuestaBase(nuevaApuesta);
        // Realizar la lógica para cambiar la apuesta base
    }

    private static void cambiarSaldoInicialJugadores() {
        int nuevoSaldoJugadores = IO.readNumber("Ingrese el nuevo saldo inicial de los jugadores: ",1);
        configuracion.setSaldoInicial(nuevoSaldoJugadores);
        // Realizar la lógica para cambiar el saldo inicial de los jugadores
    }

    private static void cambiarSaldoInicialBanca() {
        int nuevoSaldoBanca = IO.readNumber("Ingrese el nuevo saldo inicial de los jugadores: ",1);
        configuracion.setSaldoBanca(nuevoSaldoBanca);

        // Realizar la lógica para cambiar el saldo inicial de la banca
    }
}
