package TDAs;

public class Piece implements IPiece {
    //mi idea es hacer este constructor, creando una ficha que solo pueda ser "red" o "yellow" .
    private String color;

    /**
     * Crea una ficha con el color especificado.
     * RF04
     *
     * @param color Color de la ficha (red o yellow).
     */
    public Piece(String color) {
        //validar color
        if (!"red".equalsIgnoreCase(color) && !"yellow".equalsIgnoreCase(color)) {
            throw new IllegalArgumentException("Color ingresado debe ser 'red' or 'yellow'");
        }
        this.color = color.toLowerCase();
    }
    @Override
    public String getColor() {
        return color;
    }
}




