package TDAs;

/**
 * Interfaz que define las operaciones ba
 *sicas para el tablero del juego Conecta 4.
 * El tablero es una cuadrícula de 6x7 donde los jugadores colocan fichas.
 *
 * @author Martín Oviedo
 * @version 1.0
 */

public interface IBoard_21171569_OviedoAraya {
    String toString();
    boolean sePuedeJugar();
    boolean jugarFicha(int column, Piece_21171569_OviedoAraya piece);
    String verificarVictoriaVertical();
    String verificarVictoriaHorizontal();
    String verificarVictoriaDiagonal();
    String entregarGanador();
    boolean sePuedeJugarEnColumna(int column);

}