// I worked on this HW alone


/**
 * MySortedSet
 * @param <E> Type of element held
 * @author Davit Gabrielyan
 * @version 1.0
 **/


public class MySortedSet<E extends Comparable<E>>
    implements SimpleSortedSet<E> {

    private E[] abgar;
    private int count = 0;
    public static final int DEF_CAP = 100;
    private int curretnCap;

    /**
     * [MySortedSet constructor]
     */

    public MySortedSet() {
        this(DEF_CAP);
    }

    /**
     * [MySortedSet constructor]
     * @param  cap [the size of the array]
     */

    public MySortedSet(int cap) {
        curretnCap = cap;
        abgar = (E[]) new Comparable[cap]; //important
    }

    /**
     * [get method]
     * @param  e [an E type variable]
     * @return   [returns null if not in the array]
     */

    @Override
    public E get(E e) {
        try {
            int high = count;
            int low = 0;
            int x = (high + low) / 2;

            if (e == null || !this.contains(e)) {
                return null;
            } else {
                while (x > 0) {
                    if (abgar[x].compareTo(e) == 0) {
                        return e;
                    } else {
                        if (abgar[x].compareTo(e) < 0) {
                            low = x;
                            x = (high + low) / 2;
                        } else {
                            high = x;
                            x = (high + low) / 2;
                        }

                    }
                }
            }

            return null;
        } catch (Exception ape) {
            return abgar[0];
        }
    }

    /**
     * [add method]
     * @param  e [E type object]
     * @return   [true or false]
     */

    @Override
    public boolean add(E e) {

        int x = 0;

        if (this.contains(e) || e == null) {
            return false;
        } else if (this.isEmpty()) {
            abgar[0] = e;
            count++;
            return true;
        }

        if (count + 2 < curretnCap) {
            while (true) {
                if (abgar[x] != null && abgar[x].compareTo(e) > 0) {
                    for (int i = count; i > x; i--) {
                        abgar[i] = abgar[i - 1];
                    }
                    abgar[x] = e;
                    count++;
                    break;
                } else if (abgar[x] == null) {
                    count++;
                    abgar[x] = e;
                    break;
                } else {
                    x++;
                }
            }
            return true;
        } else {
            expand();
            curretnCap = 2 * curretnCap;

            while (true) {
                if (abgar[x].compareTo(e) > 0) {
                    for (int i = count; i > x; i--) {
                        abgar[i] = abgar[i - 1];
                    }
                    abgar[x] = e;
                    count++;
                    break;
                } else if (abgar[x] == null) {
                    count++;
                    abgar[x] = e;
                    break;
                } else {
                    x++;
                }
            }

            return true;
        }

    }

    /**
     * [clear method that clears the array]
     */

    @Override
    public void clear() {
        for (int i = 0; i < count; i++) {
            abgar[i] = null;
        }
        count = 0;
    }

    /**
     * [contains method]
     * @param  o [object o]
     * @return   [true if there false othervise]
     */

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < count; i++) {
            return (abgar[i].equals(o));
        }
        return false;

    }

    /**
     * [isEmpty method]
     * @return [if empthy or not]
     */

    @Override
    public boolean isEmpty() {
        return (abgar[0] == null);
    }

    /**
     * [size method]
     * @return [the size of the amout of elements]
     */

    @Override
    public int size() {
        return count;
    }

    /**
     * [toArray method]
     * @param  toFill [the array to be filled]
     * @return        [the filled array]
     */

    @Override
    public E[] toArray(E[] toFill) {
        if (toFill.length == count) {
            for (int i = 0; i < count; i++) {
                toFill[i] = abgar[i];
            }
        } else if (toFill.length > count) {
            for (int i = 0; i < count; i++) {
                toFill[i] = abgar[i];
            }
            toFill[count] = null;
        } else {
            for (int i = 0; i < toFill.length; i++) {
                toFill[i] = abgar[i];
            }

        }

        return toFill;
    }


    private void expand() {
        E[] tmp = (E[]) new Comparable[2 * curretnCap];
        toArray(tmp);
        abgar = tmp;
    }

    /**
     * [getCount mehtod]
     * @return [count]
     */

    public int getCount() {
        return count;
    }
}
