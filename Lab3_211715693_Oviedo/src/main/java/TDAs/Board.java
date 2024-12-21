package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Piece>> board;

    /**
     * RF05
     * Constructor para crear un tablero vacío.
     */


    public Board() {
        board = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            List<Piece> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null);
            }
            board.add(row);
        }
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Piece> row : board) {
            for (Piece piece : row) {
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
     * RF06
     * Método para verificar si se puede jugar.
     */
    public boolean sePuedeJugar() {
        for (List<Piece> row : board) {  // Recorremos cada fila del tablero
            if (row.contains(null)) {  // Si hay un espacio vacio en la fila
                return true;
            }
        }
        return false;  // no encuentra un espacio vacio , retorna falso
    }

    /**
     * RF07
     * Método para jugar una ficha en el tablero.
     */
    public boolean jugarFicha(int column, Piece piece) {

        // Verificar si la columna es válida
        if (column < 0 || column >= 7) {
            return false;
        }

        for (int row = 5; row >= 0; row--) {
            if (board.get(row).get(column) == null) {
                ;
                board.get(row).set(column, piece);
                return true;
            }
        }
        return false;
    }

    /**
     * Método auxiliar para obtener la pieza en una posición
     */
    private Piece getPosition(int row, int col) {
        return board.get(row).get(col);
    }

    /**
     * RF08
     * Método para verificar si hay una victoria vertical en el tablero.
     */
    public String verificarVictoriaVertical() {
        // Recorrer cada columna
        for (int col = 0; col < 7; col++) {
            // Verificar secuencias de 4 desde la fila 0 hasta la 2
            for (int row = 0; row <= 2; row++) {
                Piece actualPiece = getPosition(row, col);
                // Si la posición actual está vacía, continuar con la siguiente
                if (actualPiece == null) continue;

                // Obtener las siguientes piezas
                Piece piece1 = getPosition(row + 1, col);
                Piece piece2 = getPosition(row + 2, col);
                Piece piece3 = getPosition(row + 3, col);

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
     * RF09
     * Método para verificar si hay una victoria horizontal en el tablero.
     */
    public String verificarVictoriaHorizontal() {
        // Recorrer cada fila
        for (int row = 0; row < 6; row++) {
            // Verificar secuencias de 4 en cada fila desde la columna 0 hasta la 3
            for (int col = 0; col <= 3; col++) {
                Piece actualPiece = getPosition(row, col);
                // Si la posición actual está vacía, continuar con la siguiente
                if (actualPiece == null) continue;

                // Obtener las siguientes piezas
                Piece piece1 = getPosition(row, col + 1);
                Piece piece2 = getPosition(row, col + 2);
                Piece piece3 = getPosition(row, col + 3);
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
     * RF10 - Método para verificar si hay una victoria diagonal en el tablero.
     */
    public String verificarVictoriaDiagonal() {
        // Verificar diagonales ascendentes
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                Piece actualPiece = getPosition(row, col);
                if (actualPiece == null) continue;


                // Obtener las siguientes 3 piezas diagonales ascendentes
                Piece diag1 = getPosition(row - 1, col + 1);
                Piece diag2 = getPosition(row - 2, col + 2);
                Piece diag3 = getPosition(row - 3, col + 3);

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
                Piece actualPiece = getPosition(row, col);
                if (actualPiece == null) continue;

                // Obtener las siguientes 3 piezas diagonales descendentes
                Piece diag1 = getPosition(row + 1, col + 1);
                Piece diag2 = getPosition(row + 2, col + 2);
                Piece diag3 = getPosition(row + 3, col + 3);

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
     * RF11 - Método para entregar el ganador verificando todas las posibles condiciones de victoria.
     */
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
}
