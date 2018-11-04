/**
 * This is Grad.
 * @author Davit
 * @version 1.0
 */

public class Grad extends Student implements Alumnus {

    private String almaMater;
    private int gradYear;

    /**
     * Constructor
     * @param  name        name of the grad
     * @param  creditHours [amount of credit hours]
     * @param  inState     [if in state or not]
     * @param  almaMater   [the almaMater of the grad]
     * @param  gradYear    [the graduation year]
     */
    public Grad(String name, int creditHours,
        boolean inState, String almaMater, int gradYear) {
        super(name, creditHours, inState);
        this.almaMater = almaMater;
        this.gradYear = gradYear;
    }

    /**
     * [getAlmaMater]
     * @return [gets the AlmaMater]
     */

    public String getAlmaMater() {
        return almaMater;
    }

    /**
     * [getGradYear]
     * @return [gets the graduation year]
     */

    public int getGradYear() {
        return gradYear;
    }

    @Override
    public int compareTo(User other) {

        if (other instanceof Grad) {

            Grad casted = (Grad) other;

            if (this.gradYear != casted.gradYear) {
                return (casted.gradYear - this.gradYear);
            } else {
                return (super.compareTo(casted));
            }
        } else {
            return (this.getClass().getName().
                compareTo(other.getClass().getName()));
        }
    }
}

