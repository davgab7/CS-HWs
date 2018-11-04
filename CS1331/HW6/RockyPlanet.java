//I worked on the homework assignment alone, using only course materials.

/**
 * This is RockyPlanet.
 * @author Davit
 * @version 1.0
 */


public class RockyPlanet extends Planet {

    private boolean hasLIfe;

    /**
     * Constructor
     * @param name the name of the RockyPlanet
     * @param radius the radius of the RockyPlanet
     * @param orbitCount the orbitCount of the RockyPlanet
     * @param hasLIfe the indicator on whether RockyPlanet has life
     */

    public RockyPlanet(String name, double radius,
        int orbitCount, boolean hasLIfe) {

        super(name, radius, orbitCount);
        this.hasLIfe = hasLIfe;

    }

    /**
     *  Overriden orbit method
     */

    public void orbit() {
        super.orbit();
        hasLIfe = !hasLIfe;
    }

    /**
     * toString
     * @return formated string of the RockyPlanet
     */

    public String toString() {
        return ("RockyPlanet " + super.toString()
            + ((hasLIfe) ? ". Can have life." : " Can not have life"));
    }

    /**
     * setHasLife
     * @param hasLIfe the new indication of whether there is life on RockyPlanet
     */

    public void setHasLife(boolean hasLIfe) {
        this.hasLIfe = hasLIfe;
    }

    /**
     * getHasLife
     * @return the indication of whether there is life on RockyPlanet
     */

    public boolean getHasLife() {
        return hasLIfe;
    }
}

