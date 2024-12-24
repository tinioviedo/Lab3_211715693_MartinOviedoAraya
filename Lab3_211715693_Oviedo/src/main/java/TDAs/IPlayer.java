package TDAs;

public interface IPlayer {
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
