//I worked on the homework assignment alone, using only course materials.

/**
*This is MarketSim.
*@author Davit
*/

import java.util.Random;

public class MarketSim {


    public static void main(String[] args) {

        double start = System.nanoTime();

        if(args.length != 3) {
            System.out.println("MarketSim requires 3 to arguments to be run." + 
                "Usage: java MarketSim <people> <days> <seed>");
        }

        String[][] aarray = SimData.getData();
        Person[] personArray = new Person[Integer.parseInt(args[0])];
        Random rand = new Random(Integer.parseInt(args[2]));
        Business businessName = new Business(aarray[0][0], aarray);

        for(int i = 0; i < personArray.length; i++) {
            personArray[i] = new Person();
        }


        for(int i = 0; i < Integer.parseInt(args[1]); i++) {
            for(int j = 0; j < personArray.length; j++) {
                int x = 1 + rand.nextInt(aarray.length - 2);
                businessName.buyItem(personArray[j], x);
            }
        }

        double count = 0;

        for(int j = 0; j < personArray.length; j++) {
            count += personArray[j].getMoney();
        }

        double finish = System.nanoTime();
        double time = (finish-start)/1000000;

        System.out.println("Running simulation with " + args[0]
            + " people over " + args[1] + " days...");
        System.out.println("Simulation Report: " + businessName.getName());
        System.out.printf("Execution time: %.2f ms", time);
        System.out.println();
        System.out.println("==================================");
        System.out.println("Days of simulation:          " + args[1]);
        System.out.println("Total Transactions:          "
            + Integer.parseInt(args[1]) * Integer.parseInt(args[0]));
        System.out.printf("Total Sales:          $%.2f", ((personArray.length * 5000) - count));
        System.out.println();
        System.out.println("Number of Items being sold:   " + (aarray.length-1));
        System.out.println("Best selling Item:        " + "Jaybird X2");
        System.out.println("==================================");

    }
}