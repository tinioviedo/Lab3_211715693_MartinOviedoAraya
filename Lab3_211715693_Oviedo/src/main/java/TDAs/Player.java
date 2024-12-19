package TDAs;

public class Player {
    //atributos
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;


    /**
     *
     * RF03
     * @param id
     * @param name
     * @param color
     * @param wins
     * @param losses
     * @param draws
     * @param remainingPieces
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
        System.out.println();
    }
    //Metodos
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

}