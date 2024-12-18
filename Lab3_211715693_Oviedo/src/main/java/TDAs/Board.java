package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Integer>> board;

    public Board() {
        board = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(0);
            }
            board.add(row);
        }
    }

    public boolean sePuedeJugar() {
        for (List<Integer> row : board) {  // Recorremos cada fila del tablero
            if (row.contains(0)) {  // Si hay un 0 en la fila
                return true;
            }
        }
        return false;  // no encuentra 0 , retorna falso
    }
}
