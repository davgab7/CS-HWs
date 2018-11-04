// I worked on this assignment alone using only course material

import java.util.Scanner;
import java.io.IOException;

/**
 * This is the driver class
 * @author Davit
 * @version 1.0
 */

public class TextCheck {

    /**
     * [main The main method that does the HW assignment]
     * @param args [takes in and args array, first tow enteries
     * are file names for sentimentAnlysis]
     */

    public static void main(String[] args) {

        DoIt x = new DoIt();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                x.receiveFileSource();
                break;
            } catch (IOException e) {
                System.out.println("Sorry, but that file doesnt exist.");
            } catch (Exception o) {
                System.out.println("Make sure your inputs are valid");
            }
        }

        while (true) {
            try {
                x.receiveFileTarget();
                break;
            } catch (IOException e) {
                System.out.println("Sorry, but that file doesnt exist.");
            } catch (Exception o) {
                System.out.println("Make sure your inputs are valid");
            }
        }

        try {
            System.out.println();
            System.out.println("Analyzing");
            System.out.println("Your file contains " + x.calcWords()
                + " words and " + x.calcSentences() + " sentences.");
            System.out.println();

            System.out.println("The longest sentence in this document is:");
            System.out.println(x.theLongestSentence());
            System.out.println();

            System.out.println("Writing out target word counts to file "
                + x.getTargetFileName());
            x.targetWordCount();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Make sure all your imputs are valid.");
        }

        String a = args[0]; String b = args[1];

        while (true) {
            try {
                if (x.sentimentAnlysis(a, b) > 0) {
                    System.out.println("The sentiment analysis score is +"
                        + x.sentimentAnlysis(a, b) + ".");
                } else {
                    System.out.println("The sentiment analysis score is "
                        + x.sentimentAnlysis(a, b) + ".");
                }
                break;

            } catch (IOException e) {
                System.out.println("Sorry, one of the sentiment files doesn't"
                    + "exist, please enter them again below");
                System.out.println("Input the good word file name");
                a = input.nextLine();
                System.out.println("Input the bad word file name");
                b = input.nextLine();
            } catch (Exception o) {
                System.out.println("Make sure your inputs are valid");
            }
        }
    }
}