//I worked on the homework assignment alone, using only course materials.

/**
 * This is INstructor.
 * @author Davit
 * @version 1.0
 */

public class Instructor extends User implements Alumnus {

    protected int yearsTeaching;
    protected boolean hasTenure;
    protected String almaMater;
    protected int gradYear;

    /**
     * [Instructor Constructor]
     * @param  name [name of the Instructor]
     * @param  y    [the years he has teached for]
     * @param  h    [if he has tenure]
     * @param  a    [his almaMater]
     * @param  g    [his graduation year]
     */

    public Instructor(String name, int y, boolean h, String a, int g) {
        super(name);
        yearsTeaching = y;
        hasTenure = h;
        almaMater = a;
        gradYear = g;
    }

    /**
     * [getYearsTeaching ]
     * @return the years tought
     */

    public int getYearsTeaching() {
        return yearsTeaching;
    }

    /**
     * [getHasTenure ]
     * @return [if has tenure]
     */

    public boolean getHasTenure() {
        return hasTenure;
    }

    /**
     * [getAlmaMater ]
     * @return [almaMater in String format]
     */

    public String getAlmaMater() {
        return almaMater;
    }

    /**
     * [getGradYear ]
     * @return [his grad year]
     */

    public int getGradYear() {
        return gradYear;
    }

    @Override
    public int compareTo(User other) {

        if (other instanceof Instructor) {

            Instructor casted = (Instructor) other;

            if (this.hasTenure && casted.hasTenure) {
                if (this.yearsTeaching != casted.yearsTeaching) {
                    return (this.yearsTeaching - casted.yearsTeaching);
                } else {
                    return (super.compareTo(casted));
                }
            } else if (this.hasTenure && !casted.hasTenure) {
                return 1;
            } else if (!this.hasTenure && casted.hasTenure) {
                return -1;
            } else {
                if (this.yearsTeaching != casted.yearsTeaching) {
                    return (this.yearsTeaching - casted.yearsTeaching);
                } else {
                    return (super.compareTo(casted));
                }
            }
        } else {
            return (this.getClass().getName().
                compareTo(other.getClass().getName()));
        }

    }
}