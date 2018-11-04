//I worked on the homework assignment alone, using only course materials.

/**
 * This is Student.
 * @author Davit
 * @version 1.0
 */

public abstract class Student extends User {

    protected int creditHours;
    protected boolean inState;

    /**
     * Constructor
     * @param  name        [name of the student]
     * @param  creditHours [the amount of credit hours]
     * @param  inState     [if he is instate or not]
     *
     */

    public Student(String name, int creditHours, boolean inState) {
        super(name);
        this.creditHours = creditHours;
        this.inState = inState;
    }

    /**
     * [getCreditHours ]
     * @return [the amount of credit hours]
     */

    public int getCreditHours() {
        return this.creditHours;
    }

    /**
     * [getInState description]
     * @return [whether in state or not]
     */

    public boolean getInState() {
        return this.inState;
    }

    @Override
    public int compareTo(User other) {

        if (other instanceof Student) {

            Student casted = (Student) other;

            if (this.creditHours != casted.creditHours) {
                return (casted.creditHours - this.creditHours);
            } else {
                if ((this.inState && casted.inState)
                    || (!this.inState && !casted.inState)) {
                    return (super.compareTo(casted));
                } else if (this.inState && !casted.inState) {
                    return 1;
                } else if (!this.inState && casted.inState) {
                    return -1;
                }
            }
        } else {
            return (this.getClass().getName().
                compareTo(other.getClass().getName()));
        }

        return 0;
    }
}