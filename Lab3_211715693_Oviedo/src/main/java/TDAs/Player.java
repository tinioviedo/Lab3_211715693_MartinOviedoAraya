package TDAs;

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
     * RF03
     * Constructor para crear un jugador.
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

    @Override
    public String toString() {
        return String.format("Jugador [ID: %d, Nombre: %s, Color: %s, Fichas: %d, Victorias: %d, Derrotas: %d, Empates: %d]",
                id, name, color, remainingPieces, wins, losses, draws);
    }
    //Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;

    }
    public String getColor() {
        return color;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getRemainingPieces() {
        return remainingPieces;
    }

    //setters
    /**
     * RF15 - Actualiza las estadísticas del jugador ya sea victoria, derrota o empate
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

    // Método para restar una pieza al jugador
    public void removePiece() {
        if (remainingPieces > 0) {
            remainingPieces--; // Restamos 1 pieza
        } else {
            throw new IllegalStateException("El jugador no tiene fichas restantes");
        }

    }
}






