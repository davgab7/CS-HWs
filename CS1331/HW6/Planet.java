//I worked on the homework assignment alone, using only course materials.

/**
 * This is Planet.
 * @author Davit
 * @version 1.0
 */

public class Planet extends AstronomicalObject {

    protected final double radius;
    protected int orbitCount;

    /**
     * Constructor
     * @param name the name of the Planet
     * @param radius the radius of the Planet
     * @param orbitCount the number of Orbits of the Planet
     *
     */

    public Planet(String name, double radius, int orbitCount) {
        super(name);
        this.radius = radius;
        this.orbitCount = orbitCount;
    }

    /**
     * Orbit method
     */

    public void orbit() {
        orbitCount++;
    }

    /**
     * toString
     * @return formated string describing the planet
     */

    public String toString() {
        return ("Planet " + super.toString()
            + " Radius: " + radius + ". Orbits completed: " + orbitCount);
    }

    /**
     * getRadius
     * @return radius of the planet
     */

    public double getRadius() {
        return radius;
    }

    /**
     * @return orbitCount of the planet
     */

    public int getOrbitCount() {
        return orbitCount;
    }

    /**
     * @param x the new OrbitCount that needs to be assigned
     */

    public void setOrbitCount(int x) {
        orbitCount = x;
    }
}