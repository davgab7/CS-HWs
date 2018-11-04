
/**
 * This is Undergrad.
 * @author Davit
 * @version 1.0
 */

public class Undergrad extends Student {

    private Year year;

    /**
     * Constructor
     * @param  name        [name of the undergrad]
     * @param  creditHours [amount of credit hours]
     * @param  inState     [if in state or not]
     * @param  year        [the year standing (Object)]
     */

    public Undergrad(String name, int creditHours, boolean inState, Year year) {
        super(name, creditHours, inState);
        this.year = year;
    }

    /**
     * [getYear]
     * @return gets the year standing of the undergrad
     */

    public Year getYear() {
        return this.year;
    }

    @Override
    public int compareTo(User other) {

        if (other instanceof Undergrad) {
            Undergrad casted = (Undergrad) other;

            if (this.year.ordinal() != casted.year.ordinal()) {
                return (casted.year.ordinal() - this.year.ordinal());
            } else {
                return (super.compareTo(casted));
            }
        } else {
            return (this.getClass().getName().
                compareTo(other.getClass().getName()));
        }
    }
}