package TDAs;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n+------------------------+");
            System.out.println("|       CONECTA 4        |");
            System.out.println("+------------------------+");
            System.out.println("\n+-------- MENU ----------+");
            System.out.println("|                        |");
            System.out.println("|  1. Jugar              |");
            System.out.println("|  2. Salir              |");
            System.out.println("|                        |");
            System.out.println("+------------------------+");
            System.out.print("Seleccione una opcion: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        menuJuego(scanner);
                        break;
                    case 2:
                        System.out.println("\n+------------------------+");
                        System.out.println("| ¿Esta seguro que       |");
                        System.out.println("| desea salir? (S/N):    |");
                        System.out.println("+------------------------+");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("S")) {
                            System.out.println("\n+------------------------+");
                            System.out.println("|   ¡Gracias por jugar   |");
                            System.out.println("|      Conecta 4!        |");
                            System.out.println("+------------------------+");
                            running = false;
                        }
                        break;
                    default:
                        System.out.println("\n+------------------------+");
                        System.out.println("|   Opcion no valida.    |");
                        System.out.println("|   Intente de nuevo.    |");
                        System.out.println("+------------------------+");
                }
            } catch (Exception e) {
                System.out.println("\n+------------------------+");
                System.out.println("|   Error: Entrada       |");
                System.out.println("|   invalida.           |");
                System.out.println("+------------------------+");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        scanner.close();
    }

    private static void menuJuego(Scanner scanner) {
        Player player1 = null;
        Player player2 = null;
        boolean firstGame = true;
        boolean continuePlaying = true;

        while (continuePlaying) {
            if (firstGame) {
                // Configuración inicial del juego
                System.out.println("\n=== Crear Nuevo Juego ===");

                // Configuración Jugador 1
                System.out.println("--- Configuracion Jugador 1 ---");
                System.out.print("Ingrese nombre del jugador 1: ");
                String nombreJ1 = scanner.nextLine();
                System.out.println("Color asignado: Rojo");

                // Configuración Jugador 2
                System.out.println("\n--- Configuracion Jugador 2 ---");
                System.out.print("Ingrese nombre del jugador 2: ");
                String nombreJ2 = scanner.nextLine();
                System.out.println("Color asignado: Amarillo");

                // Solicitar número de fichas (común para ambos jugadores)
                int remainingPieces = 0;
                boolean piecesValidas = false;
                while (!piecesValidas) {
                    System.out.print("\nIngrese numero de fichas para ambos jugadores (4-21): ");
                    try {
                        remainingPieces = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        if (remainingPieces >= 4 && remainingPieces <= 21) {
                            player1 = new Player(1, nombreJ1, "red", 0, 0, 0, remainingPieces);
                            player2 = new Player(2, nombreJ2, "yellow", 0, 0, 0, remainingPieces);
                            piecesValidas = true;
                        } else {
                            System.out.println("Error: El numero de fichas debe estar entre 4 y 21.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Por favor ingrese un número válido.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }

                firstGame = false;
            } else {
                // Solicitar nuevo número de fichas para una nueva partida
                System.out.println("\n--- Nueva partida ---");
                int newRemainingPieces = 0;
                boolean piecesValidas = false;

                while (!piecesValidas) {
                    System.out.print("Ingrese numero de fichas para ambos jugadores (4-21): ");
                    try {
                        newRemainingPieces = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        if (newRemainingPieces >= 4 && newRemainingPieces <= 21) {
                            player1 = new Player(1, player1.getName(), "red", player1.getWins(),
                                    player1.getLosses(), player1.getDraws(), newRemainingPieces);
                            player2 = new Player(2, player2.getName(), "yellow", player2.getWins(),
                                    player2.getLosses(), player2.getDraws(), newRemainingPieces);
                            piecesValidas = true;
                        } else {
                            System.out.println("Error: El numero de fichas debe estar entre 4 y 21.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Por favor ingrese un numero valido.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }
            }

            try {
                // Sorteo inicial
                System.out.println("\nRealizando sorteo para determinar quien comienza...");
                Random random = new Random();
                Player jugadorInicial = random.nextBoolean() ? player1 : player2;
                System.out.println("¡El sorteo ha terminado!");

                // Crear juego
                Game game = new Game(player1, player2, null, jugadorInicial);
                System.out.println("\n¡Juego creado exitosamente!");
                System.out.println("Inicia: " + jugadorInicial.getName() + " (" + jugadorInicial.getColor() + ")");

                // Menú del juego
                boolean jugando = true;
                while (jugando) {
                    System.out.println("\n=== Conecta4 - Menu de Juego ===");
                    if (game.getCurrentplayer() != null) {
                        System.out.println("Turno de: " + game.getCurrentplayer().getName() +
                                " (" + game.getCurrentplayer().getColor() + ")");
                        System.out.println("Fichas restantes: " + game.getCurrentplayer().getRemainingPieces());
                    }
                    System.out.println("1. Realizar Jugada");
                    System.out.println("2. Estado Actual del Juego");
                    System.out.println("3. Estadisticas Generales");
                    System.out.println("4. Analisis del Tablero");
                    System.out.println("5. Volver al Menu Principal");
                    System.out.print("Ingrese su opcion: ");


    }
}