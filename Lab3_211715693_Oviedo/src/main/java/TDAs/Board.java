package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Integer>> board; // Lista de listas para representar el tablero

    /**
     * Constructor board
     */
    public Board() {
        board = new ArrayList<>();  // Inicializar tablero

        for (int i = 0; i < 6; i++) {  // de 6 filas
            List<Integer> row = new ArrayList<>();  // donde cada una de las filas corresponde a una lista
            for (int j = 0; j < 7; j++) {  // se inicializan 7 columnas con 0
                row.add(0);
            }
            board.add(row);  // Agregamos la fila al tablero
        }
    }

    // metodos
}