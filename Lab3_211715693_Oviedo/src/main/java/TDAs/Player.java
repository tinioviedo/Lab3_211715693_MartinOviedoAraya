package TDAs;

/**
 * Representa un jugador en el juego, con atributos como ID, nombre, color y estadísticas del juego.
 * Cada jugador tiene un ID, nombre, color y registra sus victorias, derrotas, empates y fichas restantes.
 * @author Martín Oviedo
 * @since 2024-12-24
 */

public class Player implements IPlayer{
    //atributos
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    /**
     * Construye un nuevo jugador con los atributos especificados.
     * RF03 - Crea un nuevo jugador para el juego.
     * @param id             identificador único del jugador (debe ser no negativo)
     * @param name           nombre del jugador
     * @param color          color ficha jugador
     * @param wins           número de victorias del jugador
     * @param losses         número de derrotas del jugador
     * @param draws          número de empates del jugador
     * @param remainingPieces número de fichas restantes del jugador (debe estar entre 4 y 21)
     * @throws IllegalArgumentException si el id es negativo o las fichas restantes están fuera del rango 4-21
     */

    public Player(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        if (id<0){
            throw new IllegalArgumentException("El ID del player no puede ser negativo");
        }
        if (remainingPieces < 4 || remainingPieces > 21)  {
            throw new IllegalArgumentException("Las fichas deben estar entre 4 y 21");
        }
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }
    //Metodos
    /**
     * Devuelve una representación en cadena de los atributos del jugador.
     * @return una cadena formateada que contiene el ID, nombre, color, fichas restantes y estadísticas del jugador
     */
    @Override
    public String toString() {
        return String.format("Jugador [ID: %d, Nombre: %s, Color: %s, Fichas: %d, Victorias: %d, Derrotas: %d, Empates: %d]",
                id, name, color, remainingPieces, wins, losses, draws);
    }
    //Getters
    /**
     * Obtiene el nombre del jugador.
     * @return el nombre del jugador
     */
    public String getName() {
        return name;
    }
    /**
     * Obtiene el identificador único del jugador.
     * @return el ID del jugador
     */
    public int getId() {
        return id;

    }
    /**
     * Obtiene el color asignado al jugador.
     * @return el color del jugador
     */
    public String getColor() {
        return color;
    }
    /**
     * Obtiene el número de juegos ganados por el jugador.
     * @return el número de victorias
     */
    public int getWins() {
        return wins;
    }
    /**
     * Obtiene el número de juegos perdidos por el jugador.
     * @return el número de derrotas
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Obtiene el número de juegos empatados por el jugador.
     * @return el número de empates
     */
    public int getDraws() {
        return draws;
    }
    /**
     * Obtiene el número de fichas restantes del jugador.
     * @return el número de fichas restantes
     */
    public int getRemainingPieces() {
        return remainingPieces;
    }

    /**
     * Actualiza las estadísticas del jugador basándose en el resultado de un juego.
     * RF15 - Actualiza las estadísticas del jugador (victoria, derrota o empate).
     * @param resultado el resultado del juego ("wins", "losses" o "draws")
     */
    public void actualizarEstadisticas(String resultado) {
        if ("wins".equals(resultado)) {
            this.wins++;
        } else if ("losses".equals(resultado)) {
            this.losses++;
        } else if ("draws".equals(resultado)) {
            this.draws++;
        }
    }

    /**
     * Resta una ficha de las fichas restantes del jugador.
     *
     * @throws IllegalStateException si el jugador no tiene fichas restantes
     */
    public void removePiece() {
        if (remainingPieces > 0) {
            remainingPieces--; // Restamos 1 pieza
        } else {
            throw new IllegalStateException("El jugador no tiene fichas restantes");
        }

    }
}






