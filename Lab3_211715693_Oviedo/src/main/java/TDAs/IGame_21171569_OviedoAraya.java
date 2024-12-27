package TDAs;

import java.util.List;

/**
 * Interfaz que define las operaciones principales del juego Conecta 4.
 * Gestiona el flujo del juego, los turnos y el estado de la partida.
 *
 * @author Martín Oviedo
 * @version 1.0
 */

public interface IGame_21171569_OviedoAraya {

    List<String> getHistory();
    boolean esEmpate();
    Player_21171569_OviedoAraya getCurrentplayer();
    Board_21171569_OviedoAraya boardGetState();
    void endGame();
    void realizarMovimiento(Player_21171569_OviedoAraya player, int column);
}
