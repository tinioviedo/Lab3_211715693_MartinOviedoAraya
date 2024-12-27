package TDAs;

/**
 * Representa una ficha individual en el juego Conecta 4.
 * @author Martín Oviedo
 * @version 1.0
 */
public class Piece_21171569_OviedoAraya implements IPiece_21171569_OviedoAraya {
    /**
     * Color de la ficha.
     * Solo puede tomar los valores "red" o "yellow".
     */
    private String color;

    /**
     * Crea una ficha con el color especificado.
     * RF04
     *
     * @param color Color de la ficha (red o yellow).
     */
    public Piece_21171569_OviedoAraya(String color) {
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




