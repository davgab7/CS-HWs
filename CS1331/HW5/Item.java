//I worked on the homework assignment alone, using only course materials.

public class Item {

    private String name;
    private double price;
    private int quantity = 0;
    private boolean inStock = false;
    private int c = 0;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item() {
        this("Item" , 0);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.inStock = true;
    }

    public void changeQuantity() {
        this.quantity--;
        c++;

        if(this.quantity <= 0) {
            inStock = false;
        }
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getInStock() {
        return inStock;
    }

    public int getC() {
        return this.c;
    }

    public String getName() {
        return this.name;
    }
}
