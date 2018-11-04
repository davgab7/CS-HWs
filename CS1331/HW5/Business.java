//I worked on the homework assignment alone, using only course materials.

/**
 * 
 */

public class Business {

    private String name;
    private Item[] ItemArray;

    /**
     * @param
     * @return
     */
    
    

    public Business(String name, String[][] aarray) {
        this.name = name;

        ItemArray = new Item[aarray.length-1];
        int c = 1;

        for(int i = 0; i < aarray.length-1; i++) {
            ItemArray[i] = new Item(aarray[c][0], Double.parseDouble(aarray[c][1]));
            ItemArray[i].setQuantity(Integer.parseInt(aarray[c++][2]));
        }
    }

    public String getName() {
        return this.name;
    }

    public void buyItem(Person p, int x) {
        if(p.getMoney() - ItemArray[x].getPrice() > 0 && ItemArray[x].getInStock()) {
            ItemArray[x].changeQuantity();
            p.changeMoney(ItemArray[x].getPrice());
        } else {

        }
        
    }


}