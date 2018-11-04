/**
 * Program to illustrate javadoc use. This is such
 * an amazing program.
 *
 * @author John Stasko
 * @version 1.0
 */
public class JavadocExample
{
    /** The year when it was created. */
    private int year;
    /** The rating it was assigned. */
    private int rating;
    /** Constant value of a perfect score. */
    public static final int perfectScore = 100;

    /** 
     * Constructor taking a year. 
     * And I can continue on to just say more and more about it.
     *
     * @param year The year it was created.
     */
     public JavadocExample(int year)
     {
       this.year = year;
     } 

   
    /** 
     * Accessor method that retrieves the year.
     *
     * @return Returns the year it was created.
     */
     public int getYear ()
     {
       return this.year;
     }


    /** 
     * Mutator method for changing the year.
     *
     * @param year The year that it is being changed to.
     */
     public void setYear (int year)
     {
       this.year = year;
     }

 
    /** 
     * Local method that calculates the rating based on the year.
     *
     * @param rate The rate of change being applied.
     */
     private void determineRating (double rate)
     {
       this.rating = (int) (rate * year);
     }
}
