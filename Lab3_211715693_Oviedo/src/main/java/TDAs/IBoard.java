package TDAs;

public interface IBoard {
    String toString();
    boolean sePuedeJugar();
    boolean jugarFicha(int column, Piece piece);
    String verificarVictoriaVertical();
    String verificarVictoriaHorizontal();
    String verificarVictoriaDiagonal();
    String entregarGanador();
    boolean sePuedeJugarEnColumna(int column);

}