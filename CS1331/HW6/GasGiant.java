//I worked on the homework assignment alone, using only course materials.

/**
 * This is GasGiant.
 * @author Davit
 * @version 1.0
 */

public class GasGiant extends Planet {

    private int numStorms;

    /**
     * Constructor
     * @param name the name of the GasGiant
     * @param radius the radius of the GasGiant
     * @param orbitCount the orbitCount of the GasGiant
     * @param numStorms the number of storms of the GasGiant
     */

    public GasGiant(String name, double radius, int orbitCount, int numStorms) {
        super(name, radius, orbitCount);
        this.numStorms = numStorms;
    }

    /**
     * Overriden orbit method
     */

    public void orbit() {
        orbitCount++;
        numStorms += 3;
    }

    /**
     * @return formated string of the GasGiant
     */

    public String toString() {
        return ("Gas Giant " + super.toString()
            + ". Number of storms: " + numStorms);
    }

    /**
     * @param numStorms the number of the storms to set to.
     */

    public void setNumStroms(int numStorms) {
        this.numStorms = numStorms;
    }

    /**
     * @return the number of storms of the GasGiant
     */

    public int getNumStroms() {
        return this.numStorms;
    }
}
