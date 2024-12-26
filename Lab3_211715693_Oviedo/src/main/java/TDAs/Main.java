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
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Iniciando nuevo juego...");
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
                        } else {
                            System.out.println("Continuando en el juego...");
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
                scanner.nextLine(); //
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
                System.out.println("Nombre registrado correctamente: " + nombreJ1);
                Piece redPiece;
                try {
                    redPiece = new Piece("red");
                    System.out.println("Color asignado: " + redPiece.getColor());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al asignar color: " + e.getMessage());
                    return;
                }


                // Configuración Jugador 2
                System.out.println("\n--- Configuracion Jugador 2 ---");
                System.out.print("Ingrese nombre del jugador 2: ");
                String nombreJ2 = scanner.nextLine();
                System.out.println("Nombre registrado correctamente: " + nombreJ2);
                Piece yellowPiece;
                try {
                    yellowPiece = new Piece("yellow");
                    System.out.println("Color asignado: " + yellowPiece.getColor());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al asignar color: " + e.getMessage());
                    return;
                }

                // Solicitar número de fichas (común para ambos jugadores)
                int remainingPieces = 0;
                boolean piecesValidas = false;
                while (!piecesValidas) {
                    System.out.print("\nIngrese numero de fichas para ambos jugadores (4-21): ");
                    try {
                        remainingPieces = scanner.nextInt();
                        scanner.nextLine(); //
                        if (remainingPieces >= 4 && remainingPieces <= 21) {
                            player1 = new Player(1, nombreJ1, redPiece.getColor(), 0, 0, 0, remainingPieces);
                            player2 = new Player(2, nombreJ2, yellowPiece.getColor(), 0, 0, 0, remainingPieces);
                            System.out.println("Numero de fichas asignado correctamente: " + remainingPieces);
                            piecesValidas = true;
                        } else {
                            System.out.println("Error: El numero de fichas debe estar entre 4 y 21.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Por favor ingrese un número válido.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }
                System.out.println("\nCreando nueva partida...");
                System.out.println("\n1. Creando tablero inicial...");
                Board newBoard = new Board();
                System.out.println("Tablero creado exitosamente:");
                System.out.println(newBoard.toString()); // Muestra el tablero vacío inicial

                System.out.println("\n2. Asignando fichas a los jugadores...");
                System.out.println("- Creando " + (player1.getRemainingPieces()) + " fichas rojas para " + player1.getName());
                System.out.println("- Creando " + (player2.getRemainingPieces()) + " fichas amarillas para " + player2.getName());

                firstGame = false;
            } else {
                // Solicitar nuevo número de fichas para una nueva partida
                try {
                    System.out.println("\n--- Configurando nueva partida ---");
                    Piece redPiece = new Piece("red");
                    Piece yellowPiece = new Piece("yellow");
                    System.out.println("Fichas creadas correctamente");

                    System.out.println("\n--- Nueva partida ---");
                    int newRemainingPieces = 0;
                    boolean piecesValidas = false;

                    while (!piecesValidas) {
                        System.out.print("Ingrese numero de fichas para ambos jugadores (4-21): ");
                        try {
                            newRemainingPieces = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer
                            if (newRemainingPieces >= 4 && newRemainingPieces <= 21) {
                                player1 = new Player(1, player1.getName(), redPiece.getColor(), player1.getWins(),
                                        player1.getLosses(), player1.getDraws(), newRemainingPieces);
                                player2 = new Player(2, player2.getName(), yellowPiece.getColor(), player2.getWins(),
                                        player2.getLosses(), player2.getDraws(), newRemainingPieces);
                                System.out.println("Numero de fichas actualizado correctamente: " + newRemainingPieces);
                                piecesValidas = true;
                            } else {
                                System.out.println("Error: El numero de fichas debe estar entre 4 y 21.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Por favor ingrese un numero valido.");
                            scanner.nextLine(); // Limpiar buffer
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al crear las fichas: " + e.getMessage());
                    return;
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
                    System.out.println("4. Volver al Menu Principal");
                    System.out.print("Ingrese su opcion: ");

                    try {
                        int opcionJuego = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        switch (opcionJuego) {
                            case 1:
                                realizarJugada(game, scanner);
                                break;
                            case 2:
                                mostrarEstadoActual(game);
                                break;
                            case 3:
                                mostrarEstadisticas(player1, player2);
                                break;
                            case 4:
                                System.out.println("\n¿Esta seguro que desea terminar el juego actual y retirarse? (S/N): ");
                                String confirmacion = scanner.nextLine().trim().toUpperCase();

                                if (confirmacion.equals("S")) {
                                    // Identificar al jugador que se retira
                                    Player jugadorActual = game.getCurrentplayer();
                                    if (jugadorActual != null) {
                                        System.out.println("El jugador " + jugadorActual.getName() + " se ha retirado.");
                                        // Finalizar el juego indicando quién se retiró
                                        game.endGame(jugadorActual);
                                    }
                                    jugando = false;
                                    continuePlaying = false;
                                    System.out.println("\nVolviendo al menú principal...");
                                } else {
                                    System.out.println("Continuando con el juego...");
                                }
                                break;

                            default:
                                System.out.println("Opcion no valida. Por favor intente de nuevo.");
                        }

                        // Verificar si el juego ha terminado
                        if (game.getCurrentplayer() == null) {
                            System.out.println("\n¡El juego ha terminado!");
                            // Agregar análisis final de la partida
                            System.out.println("\n=== Analisis Final de la Partida ===");
                            // Mostrar el estado final del tablero
                            System.out.println("\nTablero final:");
                            System.out.println(game.boardGetState());

                            // Mostrar resultado final
                            System.out.println("\nResultado del analisis:");
                            System.out.println("- Victoria vertical: " + game.boardGetState().verificarVictoriaVertical());
                            System.out.println("- Victoria horizontal: " + game.boardGetState().verificarVictoriaHorizontal());
                            System.out.println("- Victoria diagonal: " + game.boardGetState().verificarVictoriaDiagonal());
                            System.out.println("- Empate: " + (game.esEmpate() ? "Si" : "No"));
                            mostrarEstadisticas(player1, player2);

                            System.out.print("\n¿Desea jugar otra partida? (S/N): ");
                            String respuesta = scanner.nextLine().trim().toUpperCase();
                            if (respuesta.equals("S")) {
                                jugando = false;
                                System.out.println("\n¡Iniciando nueva partida!");
                            } else {
                                jugando = false;
                                continuePlaying = false;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Entrada invalida. Por favor ingrese un numero valido.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear el juego: " + e.getMessage());
                continuePlaying = false;
            }
        }
    }

    private static void realizarJugada(Game game, Scanner scanner) {
        Player jugadorActual = game.getCurrentplayer();
        if (jugadorActual == null) {
            System.out.println("El juego ya ha terminado.");
            return;
        }

        boolean jugadaValida = false;
        while (!jugadaValida) {
            System.out.println("\n=== Realizar Jugada ===");
            System.out.println("Turno de: " + jugadorActual.getName() +
                    " (" + jugadorActual.getColor() + ")");
            System.out.println("Fichas restantes: " + jugadorActual.getRemainingPieces());
            System.out.print("Seleccione columna (1-7) o 0 para cancelar: ");

            try {
                int columna = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                if (columna == 0) {
                    System.out.println("Jugada cancelada correctamente.");
                    return;
                }

                if (columna < 1 || columna > 7) {
                    System.out.println("Error: Por favor seleccione una columna entre 1 y 7.");
                    continue;
                }

                try {
                    game.realizarMovimiento(jugadorActual, columna - 1);
                    System.out.println("\nMovimiento realizado exitosamente en la columna " + columna);
                    System.out.println(game.boardGetState());
                    jugadaValida = true;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Por favor intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un numero valido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    private static void mostrarEstadoActual(Game game) {
        System.out.println("\n+------------------------+");
        System.out.println("|    ESTADO DEL JUEGO    |");
        System.out.println("+------------------------+");

        System.out.println("\n+----- TABLERO ACTUAL ----+");
        System.out.println(game.boardGetState());
        System.out.println("+------------------------+");

        System.out.println("\n+----- JUGADOR ACTUAL ----+");
        if (game.getCurrentplayer() != null) {
            System.out.println("| Nombre: " + game.getCurrentplayer().getName());
            System.out.println("| Color: " + game.getCurrentplayer().getColor());
            System.out.println("| Fichas: " + game.getCurrentplayer().getRemainingPieces());
        } else {
            System.out.println("| El juego ha terminado");
        }
        System.out.println("+------------------------+");

        System.out.println("\n+--- HISTORIAL DE JUEGO ---+");
        mostrarHistorial(game);
        System.out.println("+------------------------+");
    }

    private static void mostrarEstadisticas(Player player1, Player player2) {
        System.out.println("\n=== Estadisticas Actuales ===");
        System.out.println("Jugador #" + player1.getId() + " - " + player1.getName() + " (" + player1.getColor() + "):");
        System.out.println("- Victorias: " + player1.getWins());
        System.out.println("- Derrotas: " + player1.getLosses());
        System.out.println("- Empates: " + player1.getDraws());
        System.out.println("- Fichas restantes: " + player1.getRemainingPieces());

        System.out.println("\nJugador #" + player2.getId() + " - " + player2.getName() + " (" + player2.getColor() + "):");
        System.out.println("- Victorias: " + player2.getWins());
        System.out.println("- Derrotas: " + player2.getLosses());
        System.out.println("- Empates: " + player2.getDraws());
        System.out.println("- Fichas restantes: " + player2.getRemainingPieces());
    }
    private static void mostrarHistorial(Game game) {
        java.util.List<String> historial = game.getHistory();
        if (historial.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
        } else {
            for (String movimiento : historial) {
                System.out.println(movimiento);
            }
        }
    }

    private static void menuAnalisisTablero(Game game, Scanner scanner) {
        boolean analizando = true;
        while (analizando) {
            System.out.println("\n=== Analisis del Tablero ===");
            System.out.println("1. Verificar Victoria Vertical");
            System.out.println("2. Verificar Victoria Horizontal");
            System.out.println("3. Verificar Victoria Diagonal");
            System.out.println("4. Verificar Empate");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opcion: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado vertical: " + game.boardGetState().verificarVictoriaVertical());
                        break;
                    case 2:
                        System.out.println("Resultado horizontal: " + game.boardGetState().verificarVictoriaHorizontal());
                        break;
                    case 3:
                        System.out.println("Resultado diagonal: " + game.boardGetState().verificarVictoriaDiagonal());
                        break;
                    case 4:
                        System.out.println("¿Hay empate? " + (game.esEmpate() ? "Si" : "No"));
                        break;
                    case 5:
                        analizando = false;
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada invalida. Por favor ingrese un numero valido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
}