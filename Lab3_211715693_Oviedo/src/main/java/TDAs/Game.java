package TDAs;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame{
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentplayer;
    private List<String> history;

    /**
     * RF12 - Constructor para crear una nueva partida.
     * @param player1 El primer jugador de la partida.
     * @param player2 El segundo jugador de la partida.
     * @param board El tablero de juego.
     * @param currentplayer El jugador que comenzará la partida.
     */

    public Game(Player player1, Player player2, Board board, Player currentplayer ) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentplayer = currentplayer;
        this.history = new ArrayList<>();
    }
    /**
     * RF13 - Genera un historial de movimientos de la partida.
     * @return Una lista con el historial de movimientos, enumerados.
     */
    @Override
    public List<String> getHistory() {
        List<String> enumeratedHistory = new ArrayList<>();
        for (int i = 0; i < history.size(); i++) {
            enumeratedHistory.add((i + 1) + ". " + history.get(i));
        }
        return enumeratedHistory;
    }

    /**
     * RF14 - Método que verifica si el estado actual del juego es empate.
     * @return true si el juego ha terminado en empate, false si no.
     */
    @Override
    public boolean esEmpate() {
        // Primero se tiene que  verificar que no haya un ganador, pq se puede dar el caso de que ganen y queden sin fichas
        if (!"No hay ganador".equals(board.entregarGanador())) {
            return false;
        }

        // Luego verificar si ambos jugadores se quedaron sin fichas o si el tablero está lleno
        return (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0) || !board.sePuedeJugar();
    }
    /**
     * RF16 - Selector que obtiene el estado actual del jugador cuyo turno está en curso en el juego.
     * @return El jugador cuyo turno está en curso.
     */
    @Override
    public Player getCurrentplayer() {
        return currentplayer;
    }

    /**
     * RF17 - Selector que obtiene el estado actual del tablero en el juego.
     * @return El tablero de juego actual.
     */
    @Override
    public Board boardGetState() {
        return this.board;
    }

    /**
     * RF18 - Método que finaliza el juego actualizando las estadísticas de los jugadores
     * según el resultado y no permitiendo futuras jugadas.
     */
    @Override
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
    public void endGame(Player quitter) {
        if (quitter != null) {
            // Si un jugador se retira, el otro es automáticamente el ganador
            Player winner = (quitter == player1) ? player2 : player1;

            // Actualizar estadísticas
            winner.actualizarEstadisticas("wins");
            quitter.actualizarEstadisticas("losses");

            System.out.println("El jugador " + quitter.getName() + " se ha retirado.");
            System.out.println("El ganador es: " + winner.getName());
        }

        // Finalizar el juego
        currentplayer = null;
    }


    @Override
    /**
     * RF19 - Método que realiza un movimiento en el juego.
     * @param player El jugador que realiza el movimiento.
     * @param column La columna donde el jugador intenta colocar una ficha.
     * @throws IllegalArgumentException Si no es el turno del jugador, si el jugador no tiene fichas restantes,
     * si la columna es inválida o si no se puede jugar en la columna seleccionada.
     * @throws IllegalStateException Si el juego ha terminado o no se pudo colocar la ficha.
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
        history.add(player.getName() + " jugo en la columna " + (column + 1));

        // Verificar si hay un ganador o si el juego ha terminado en empate
        String ganador = board.entregarGanador();
        if (!"No hay ganador".equals(ganador)) {
            endGame();
        } else if (esEmpate()) {
            endGame();
        } else {
            // Solo cambiar el turno si el juego no ha terminado
            currentplayer = (currentplayer == player1) ? player2 : player1;
        }
    }

}

