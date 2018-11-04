//I worked on the homework assignment alone, using only course materials.

/**
 * This is AstronomicalObject.
 * @author Davit
 * @version 1.0
 */

public class AstronomicalObject {

    protected String name;

    /**
     * The Constructor
     * @param name the name of the AstronomicalObject
     *
     */

    public AstronomicalObject(String name) {
        this.name = name;

    }

    /**
     * setName
     * @param s the new name of the AstronomicalObject
     */
    public void setName(String s) {
        this.name = s;
    }

    /**
     * getName
     * @return name of the AstronomicalObject
     */
    public String getName() {
        return this.name;
    }

    /**
     * toString
     * @return the formated string of AstronomicalObject's name
     */

    public String toString() {
        return (this.name + ".");
    }
}