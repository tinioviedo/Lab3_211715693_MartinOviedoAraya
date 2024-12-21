package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentplayer;
    private List<String> history;

    /**
     * RF12 - Constructor para crear una nueva partida.
     */

    public Game(Player player1, Player player2, Board board, Player currentplayer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentplayer = currentplayer;
        this.history = new ArrayList<>();
    }

    /**
     * RF13 - Genera un historial de movimientos de la partida.
     */

    public List<String> getHistory() {
        List<String> enumeratedHistory = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            enumeratedHistory.add((i + 1) + ". " + history.get(i));
        }
        return enumeratedHistory;
    }
}