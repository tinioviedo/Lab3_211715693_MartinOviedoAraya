package TDAs;

import java.util.List;

public interface IGame {

    List<String> getHistory();
    boolean esEmpate();
    Player getCurrentplayer();
    Board boardGetState();
    void endGame();
    void realizarMovimiento(Player player, int column);
}
