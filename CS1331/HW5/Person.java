//I worked on the homework assignment alone, using only course materials.

/**
 * 
 */

public class Person {

    private double money;

    public Person(double money) {
        this.money = money;
    }

    public Person() {
        this(5000);
    }

    public double getMoney() {
        return this.money;
    }

    public void changeMoney(double price) {
        this.money = this.money - price;
    }
}