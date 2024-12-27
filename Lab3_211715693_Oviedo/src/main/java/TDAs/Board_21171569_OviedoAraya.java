package TDAs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el tablero de juego de Conecta 4.
 * El tablero está compuesto por una lista de listas, donde cada elemento puede ser una ficha o un espacio vacío.
 * Incluye métodos para gestionar el estado del tablero y verificar condiciones de victoria.
 * @author Martín Oviedo
 * @version 1.0
 */

public class Board_21171569_OviedoAraya implements IBoard_21171569_OviedoAraya {
    /**
     * Matriz que representa el tablero de juego.
     * Lista de listas donde cada elemento es una Piece o null si está vacío.
     * La estructura tiene 6 filas y 7 columnas.
     */
    private List<List<Piece_21171569_OviedoAraya>> board;

    /**
     * Constructor para inicializar un tablero vacío.
     * RF05 - Crea un tablero con 6 filas y 7 columnas, todas inicialmente vacías.
     */


    public Board_21171569_OviedoAraya() {
        board = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            List<Piece_21171569_OviedoAraya> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null);
            }
            board.add(row);
        }
    }

    /**
     * Devuelve una representación en texto del tablero.
     * Cada celda vacía se representa con un guion (-), y las celdas ocupadas muestran la inicial del color de la ficha.
     * @return una cadena que representa el tablero de juego
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Piece_21171569_OviedoAraya> row : board) {
            for (Piece_21171569_OviedoAraya piece : row) {
                if (piece == null) {
                    builder.append("- "); // Espacio vacío
                } else {
                    builder.append(piece.getColor().charAt(0)).append(" "); // Primera letra del color
                }
            }
            builder.append("\n"); // Nueva línea después de cada fila
        }
        return builder.toString();
    }

    /**
     * Verifica si es posible seguir jugando en el tablero.
     * RF06 - Recorre todas las celdas del tablero buscando al menos un espacio vacío.
     * @return true si hay espacios vacíos, false si el tablero está lleno
     */
    @Override
    public boolean sePuedeJugar() {
        for (List<Piece_21171569_OviedoAraya> row : board) {  // Recorremos cada fila del tablero
            if (row.contains(null)) {  // Si hay un espacio vacio en la fila
                return true;
            }
        }
        return false;  // no encuentra un espacio vacio , retorna falso
    }
    /**
     * Juega una ficha en la columna especificada.
     * RF07 - Intenta colocar una ficha en la columna dada, comenzando desde la fila más baja.
     * @param column la columna donde se intentará colocar la ficha
     * @param piece  la ficha que se desea colocar
     * @return true si la ficha se colocó con éxito, false si la columna está llena o es inválida
     */
    @Override
    public boolean jugarFicha(int column, Piece_21171569_OviedoAraya piece) {

        // Verificar si la columna es válida
        if (column < 0 || column >= 7) {
            return false;
        }

        for (int row = 5; row >= 0; row--) {
            if (board.get(row).get(column) == null) {;
                board.get(row).set(column, piece);
                return true;
            }
        }
        return false;
    }
    /**
     * Obtiene la ficha en una posición específica del tablero.
     * @param row la fila de la posición
     * @param col la columna de la posición
     * @return la ficha en la posición especificada, o null si está vacía
     */
    private Piece_21171569_OviedoAraya getPosition(int row, int col) {
        return board.get(row).get(col);
    }


    /**
     * Verifica si hay una victoria vertical en el tablero.
     * RF08 - Comprueba cada columna en busca de 4 fichas consecutivas del mismo color.
     * @return el color del jugador que ganó, o "No hay ganador" si no hay victoria
     */
    @Override
    public String verificarVictoriaVertical() {
        // Recorrer cada columna
        for (int col = 0; col < 7; col++) {
            // Verificar secuencias de 4 desde la fila 0 hasta la 2
            for (int row = 0; row <= 2; row++) {
                Piece_21171569_OviedoAraya actualPiece = getPosition(row, col);
                // Si la posición actual está vacía, continuar con la siguiente
                if (actualPiece == null) continue;

                // Obtener las siguientes piezas
                Piece_21171569_OviedoAraya piece1 = getPosition(row + 1, col);
                Piece_21171569_OviedoAraya piece2 = getPosition(row + 2, col);
                Piece_21171569_OviedoAraya piece3 = getPosition(row + 3, col);

                // Verificar que ninguna sea null antes de comparar
                if (piece1 == null || piece2 == null || piece3 == null) continue;


                // Verificar si hay 4 fichas consecutivas del mismo color
                if (actualPiece.getColor().equals(getPosition(row + 1, col).getColor()) &&
                        actualPiece.getColor().equals(getPosition(row + 2, col).getColor()) &&
                        actualPiece.getColor().equals(getPosition(row + 3, col).getColor())) {
                    return actualPiece.getColor();
                }
            }
        }
        return "No hay ganador";
    }
    /**
     * Verifica si hay una victoria horizontal en el tablero.
     * RF09 - Comprueba cada fila en busca de 4 fichas consecutivas del mismo color.
     * @return el color del jugador que ganó, o "No hay ganador" si no hay victoria
     */
    @Override
    public String verificarVictoriaHorizontal() {
        // Recorrer cada fila
        for (int row = 0; row < 6; row++) {
            // Verificar secuencias de 4 en cada fila desde la columna 0 hasta la 3
            for (int col = 0; col <= 3; col++) {
                Piece_21171569_OviedoAraya actualPiece = getPosition(row, col);
                // Si la posición actual está vacía, continuar con la siguiente
                if (actualPiece == null) continue;

                // Obtener las siguientes piezas
                Piece_21171569_OviedoAraya piece1 = getPosition(row, col + 1);
                Piece_21171569_OviedoAraya piece2 = getPosition(row, col + 2);
                Piece_21171569_OviedoAraya piece3 = getPosition(row, col + 3);
                // Verificar que ninguna sea null antes de comparar
                if (piece1 == null || piece2 == null || piece3 == null) continue;

                // Verificar si hay 4 fichas consecutivas del mismo color
                if (actualPiece.getColor().equals(getPosition(row, col + 1).getColor()) &&
                        actualPiece.getColor().equals(getPosition(row, col + 2).getColor()) &&
                        actualPiece.getColor().equals(getPosition(row, col + 3).getColor())) {
                    return actualPiece.getColor();
                }
            }
        }
        return "No hay ganador";
    }
    /**
     * Verifica si hay una victoria diagonal en el tablero.
     * RF10 - Comprueba diagonales ascendentes y descendentes en busca de 4 fichas consecutivas del mismo color.
     * @return el color del jugador que ganó, o "No hay ganador" si no hay victoria
     */
    @Override
    public String verificarVictoriaDiagonal() {
        // Verificar diagonales ascendentes
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                Piece_21171569_OviedoAraya actualPiece = getPosition(row, col);
                if (actualPiece == null) continue;


                // Obtener las siguientes 3 piezas diagonales ascendentes
                Piece_21171569_OviedoAraya diag1 = getPosition(row - 1, col + 1);
                Piece_21171569_OviedoAraya diag2 = getPosition(row - 2, col + 2);
                Piece_21171569_OviedoAraya diag3 = getPosition(row - 3, col + 3);

                // Verificar que ninguna de las piezas sea null antes de comparar
                if (diag1 == null || diag2 == null || diag3 == null) continue;

                if (actualPiece.getColor().equals(diag1.getColor()) &&
                        actualPiece.getColor().equals(diag2.getColor()) &&
                        actualPiece.getColor().equals(diag3.getColor())) {
                    return actualPiece.getColor();
                }
            }
        }

        // Verificar diagonales descendentes
        for (int row = 0; row <= 2; row++) {
            for (int col = 0; col <= 3; col++) {
                Piece_21171569_OviedoAraya actualPiece = getPosition(row, col);
                if (actualPiece == null) continue;

                // Obtener las siguientes 3 piezas diagonales descendentes
                Piece_21171569_OviedoAraya diag1 = getPosition(row + 1, col + 1);
                Piece_21171569_OviedoAraya diag2 = getPosition(row + 2, col + 2);
                Piece_21171569_OviedoAraya diag3 = getPosition(row + 3, col + 3);

                // Verificar que ninguna de las piezas sea null antes de comparar
                if (diag1 == null || diag2 == null || diag3 == null) continue;

                if (actualPiece.getColor().equals(diag1.getColor()) &&
                        actualPiece.getColor().equals(diag2.getColor()) &&
                        actualPiece.getColor().equals(diag3.getColor())) {
                    return actualPiece.getColor();
                }
            }
        }
        return "No hay ganador";
    }

    /**
     * Determina el ganador verificando todas las condiciones de victoria.
     * RF11 - Integra las verificaciones de victoria vertical, horizontal y diagonal.
     * @return el color del jugador ganador, o "No hay ganador" si nadie ha ganado
     */
    @Override
    public String entregarGanador() {
        String verticalWinner = verificarVictoriaVertical();
        if (!"No hay ganador".equals(verticalWinner)) {
            return verticalWinner;
        }

        String horizontalWinner = verificarVictoriaHorizontal();
        if (!"No hay ganador".equals(horizontalWinner)) {
            return horizontalWinner;
        }

        String diagonalWinner = verificarVictoriaDiagonal();
        if (!"No hay ganador".equals(diagonalWinner)) {
            return diagonalWinner;
        }

        return "No hay ganador";
    }

    /**
     * metodo para verificar si se puede jugar en la columna especificada.
     * @param column La columna donde el jugador intenta colocar una ficha.
     * @return true si hay espacio en la columna para colocar una ficha, false si no.
     */
    @Override
    public boolean sePuedeJugarEnColumna(int column) {
        // Verificar si la columna es válida
        if (column < 0 || column >= 7) {
            return false;  // Columna inválida
        }

        // Comprobar si la posición más alta de la columna está vacía (fila 0)
        return board.get(0).get(column) == null;
    }


}
