package TDAs;

/**
 * Interfaz que define las propiedades y comportamientos de un jugador.
 * Incluye información personal, estadísticas y gestión de fichas.
 *
 * @author Martín Oviedo
 * @version 1.0
 */

public interface IPlayer_21171569_OviedoAraya {
    String toString();
    String getName();
    int getId();
    String getColor();
    int getWins();
    int getLosses();
    int getDraws();
    int getRemainingPieces();
    void actualizarEstadisticas(String resultado);
    void removePiece();

}
