//I worked on the homework assignment alone, using only course materials.

/**
 * This is Star.
 * @author Davit
 * @version 1.0
 */

public class Star extends AstronomicalObject {

    private Color color;
    private boolean isSun;

    /**
     * Constructor
     * @param name the name of the Star
     * @param id the id of the color of the star
     *
     */

    public Star(String name, int id) {
        super(name);
        this.color = Color.getColorById(id);
        if (this.color == Color.RED) {
            isSun = false;
        } else {
            isSun = true;
        }
    }

    /*public void whatColor() {
        if(this.color == Color.RED)
            isSun = false;
        else
            isSun = true;

    }*/

    /**
     * toString
     * @return Formated String that describes the star
     */

    public String toString() {
        if (isSun) {
            return ("Star " + name + ". Color: "
                + color + ". Can have planets");
        } else {
            return ("Star " + name + ". Color: "
                + color + ". Can not have planets");
        }
    }

    /**
     * getColor
     * @return the color of the star
     */

    public Color getColor() {
        return color;

    }

    /**
     * setColor
     * @param c color of the star that is of an Enum Color Type
     */

    public void setColor(Color c) {
        this.color = c;
    }
}
