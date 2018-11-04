//I worked on the homework assignment alone, using only course materials.

/**
 * This is User.
 * @author Davit
 * @version 1.0
 */

public abstract class User implements Comparable<User> {

    protected String name;
    protected int id;
    private static int n = 1;

    /**
     * [User Constructor]
     * @param  name [name of the user]
     */

    public User(String name) {
        this.name = name;
        this.id = n++;
    }

    /**
     * [getType ]
     * @return [the name of the Class]
     */

    public String getType() {
        return this.getClass().getName();
    }

    /**
     * [getName ]
     * @return [the name of the user]
     */

    public String getName() {
        return this.name;
    }

    /**
     * [getId ]
     * @return [the id of the user]
     */

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(User other) {
        return (this.id - other.id);
    }

}