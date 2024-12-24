package TDAs;
//hacer que sea aleatorio el turno del jugador al comenzar, habrpa un menu principal de inicio, que tendrá jugar o salir
// otro submenu tendrá 5 opciones realizar jugada, estado juego, estadisticas, estado tablero y otra para retroceder
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== CONECTA 4 ===");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        menuJuego(scanner);
                        break;
                    case 2:
                        System.out.println("¿Está seguro que desea salir? (S/N): ");
                        String confirmacion = scanner.nextLine();
                        if (confirmacion.equalsIgnoreCase("S")) {
                            System.out.println("¡Gracias por jugar Conecta4!");
                            running = false;
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        scanner.close();
    }
    private static void menuJuego(Scanner scanner) {