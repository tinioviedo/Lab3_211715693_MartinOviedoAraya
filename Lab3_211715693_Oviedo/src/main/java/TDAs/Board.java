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
            if (board.get(row).get(column) == null) {;
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
