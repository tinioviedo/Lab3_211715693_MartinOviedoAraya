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

    /**
     * RF14 - Metodo que verifica si el estado actual del juego es empate
     */
    public boolean esEmpate() {
        // Verificar si ambos jugadores se quedaron sin fichas
        if (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0) {
            return true;
        }

        // Verificar si el tablero está lleno (no se pueden realizar más jugadas)
        if (!board.sePuedeJugar()) {
            return true;
        }

        return false;
    }

    /**
     * RF16 - Selector que obtiene el estado actual del jugador cuyo turno esta en curso el juego
     */
    public Player getCurrentplayer() {
        return currentplayer;
    }

    /**
     * RF17 - Selector que obtiene el estado actual del tablero en el juego
     */
    public Board boardGetState() {
        return this.board;
    }

    /**
     * RF18 - Método que finaliza el juego
     actualizando las estadísticas de los jugadores según el resultado y no permitiendo futuras
     jugadas.

     */
    public void endGame() {
        if (esEmpate()) {
            player1.actualizarEstadisticas("draws");
            player2.actualizarEstadisticas("draws");
        } else {
            // Determinar ganador y perdedor basado en el color
            Player winner;
            Player loser;

            if (board.entregarGanador().equals("red")) {
                winner = player1;
                loser = player2;
            } else {
                winner = player2;
                loser = player1;
            }

            //actualizar estadisticas
            winner.actualizarEstadisticas("wins");
            loser.actualizarEstadisticas("losses");
        }

        // jugador actual null luego de termianada partida
        currentplayer = null;
    }
    /**
     * RF19 - Método que realiza un movimiento en el juego.
     */
    public void realizarMovimiento(Player player, int column) {
        // Verificar que sea el turno del jugador correcto
        if (player != currentplayer) {
            throw new IllegalArgumentException("No es el turno del jugador actual");
        }

        // Verificar si hay un juego en curso
        if (currentplayer == null) {
            throw new IllegalStateException("El juego ya ha terminado");
        }

        // Verificar si el jugador tiene fichas restantes
        if (player.getRemainingPieces() == 0) {
            throw new IllegalArgumentException("El jugador no tiene fichas restantes");
        }

        // Verificar si la columna es válida
        if (column < 0 || column >= 7) {
            throw new IllegalArgumentException("Columna inválida");
        }

        // Verificar si se puede jugar en la columna
        if (!board.sePuedeJugarEnColumna(column)) {
            throw new IllegalArgumentException("No se puede jugar en la columna seleccionada");
        }

        // Obtener la ficha del jugador y jugarla
        Piece piece = new Piece(player.getColor());
        boolean jugadaExitosa = board.jugarFicha(column, piece);

        if (!jugadaExitosa) {
            throw new IllegalStateException("No se pudo colocar la ficha en la columna " + column);
        }

        // Disminuir la cantidad de fichas del jugador
        player.removePiece();

        // Actualizar el historial de movimientos
        history.add(player.getName() + " jugó en la columna " + (column +1));

        // Verificar si hay un ganador o si el juego ha terminado en empate
        String ganador = board.entregarGanador();
        if (!"No hay ganador".equals(ganador) || esEmpate()) {
            endGame();
        } else {
            // Solo cambiar el turno si el juego no ha terminado
            currentplayer = (currentplayer == player1) ? player2 : player1;
        }
    }


}
