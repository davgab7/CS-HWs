//I worked on the homework assignment alone, using only course materials.

import java.text.DecimalFormat;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        double f , k;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a temperature in degrees Fahrenheit:");

        DecimalFormat form = new DecimalFormat("#.00");

        f = input.nextDouble();

        k = ((f + 459.67) * 5) / 9;

        System.out.println(f + " degrees Fahrenheit is " + form.format(k)
            + " Kelvin");
    }
}

