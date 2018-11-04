//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;


public class Doomsday {
    public static void main(String[] args) {

        int year , day , month , x , z, y , answer, a = 0 , b;

        System.out.println("Welcome to the Doomsday Calculator!");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter year (1900-1999): ");
            year = input.nextInt();
            System.out.print("Enter month (1-12): ");
            month = input.nextInt();
            System.out.print("Enter day: ");
            day = input.nextInt();

            if (day < 1|| day > 31 || month < 1 || month > 12 || year < 1900
                || year > 1999 || (month == 2 && day == 29
                && (year % 100) % 4 != 0)
                || ((month == 6 || month == 2 || month == 4 || month == 9
                || month == 11) && day > 30)) {

                System.out.println("The entered date is invalid!");

            } else {
                x = year % 100;
                y = (x / 12) + (x % 12) + ((x % 12) / 4);
                z = (y + 3) % 7;


                if (month == 1 && (year % 100) % 4 == 0) {
                    a = (day - 4);

                } else if (month == 1) {
                    a = (day - 3);

                } else if (month == 2 && (year % 100) % 4 == 0) {
                    a = (day - 29);

                } else if (month == 2) {
                    a = (day - 28);

                } else if (month == 3) {
                    a = (day - 7);

                } else if (month == 4) {
                    a = (day - 4);

                } else if (month == 5) {
                    a = (day - 9);

                } else if (month == 6) {
                    a = (day - 6);

                } else if (month == 7) {
                    a = (day - 11);

                } else if (month == 8) {
                    a = (day - 8);

                } else if (month == 9) {
                    a = (day - 5);

                } else if (month == 10) {
                    a = (day - 10);

                } else if (month == 11) {
                    a = (day - 7);

                } else if (month == 12) {
                    a = (day - 12);
                }

                answer = (a + z) % 7;

                if (answer == 0 || answer == -7) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Sunday");

                } else if (answer == 1 || answer == -6) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Monday");

                } else if (answer == 2 || answer == -5) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Tuesday");

                } else if (answer == 3 || answer == -4) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Wednesday");

                } else if (answer == 4 || answer == -3) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Thursday");

                } else if (answer == 5 || answer == -2) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Friday");

                } else if (answer == 6 || answer == -1) {
                    System.out.println(month + "/" + day + "/" + year
                        + " was on a Saturday");
                }


            }



            System.out.print("Do you want to enter another date (type ’y’"
                + "or ’n’) ");

            if (input.next().equals("y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public int me(){}
}