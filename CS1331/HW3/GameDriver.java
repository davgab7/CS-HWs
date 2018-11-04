import java.util.Scanner;

/**
 * Driver file for RandomGame. This class handles processing which game the
 * user wants to play, creating the RandomGame objects to process gameplay,
 * and keeping track of the user's score.
 */
public class GameDriver {

    enum SuitName {
        spades, clubs, diamonds, hearts;
    }

    // These are the RandomGame static variables given to you.
    private static RandomGame coinGame;
    private static RandomGame cardSuitGame;
    private static RandomGame cardRankGame;
    private static RandomGame diceGame;

    // This variable should default to be 128.
    private static int bufferSize = 128;

    // Score variable goes here!. Should be a static int.
    private static int score = 0;

    /**
     * Main method. The main method should take in an argument from the command
     * line to be the ran dom values array size, or 128 if an argument is not
     * given. The main method should then loop as long as the user is willing to
     * play the game and ask the user which game to play. Based on what the user
     * says, the RandomGame should either call the play___Game() method or
     * tell the user the input is invalid and ask if they want to play again.
     * Once the user has finished playing the total score should be printed.
     * @param args The size of the array buffer of random values.
     */
    public static void main(String[] args) {
        // YOUR CODE HERE : Initialize the buffer size.

        // Initialize the provided games. DO NOT MODIFY!
        cardRankGame = new RandomGame(13, bufferSize);
        cardSuitGame = new RandomGame(4, bufferSize);
        coinGame = new RandomGame(2, bufferSize);
        // YOUR CODE HERE : Process which game to play.



        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the game you would like to play (coins, di"
                + "ce, cards): ");
            String m = input.next();
            if (m.equals("coins")) {
                playCoinGame(input);
            } else if (m.equals("dice")) {
                playDiceGame(input);
            } else if (m.equals("cards")) {
                playCardGame(input);
            } else {
                System.out.println("Your input is invalid ");
            }

            System.out.print("Would you like to play again? (y/n): ");
            if (input.next().equals("y")) {
                continue;
            } else {
                System.out.println("Your score is: " + score);
                break;
            }


        }
    }



    /**
     * Do a coin game with the given input scanner.
     * This method asks the user for input using the given scanner, checks
     * if it is correct and prints the results.
     * Do not modify this method! This is a sample method for how
     * RandomGame is used.
     * @param inScanner The scanner to scan input from.
     */
    public static void playCoinGame(Scanner inScanner) {
        System.out.print("Enter your guess (h/t): ");
        int guess = (inScanner.next().charAt(0) == 'h') ? 1 : 2;
        boolean right = coinGame.checkGuess(guess);
        int correct = coinGame.getLastEvent();
        if (!right) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score++;
        }
        System.out.printf(" Your guess: %s; Correct: %s",
                ((guess == 1) ? "h" : "t"), ((correct == 1) ? "h" : "t")
                + "\n");
    }

    /**
     * Do a dice game with the given input scanner. This method
     * first should ask the user how many faces they want on their die, then
     * should ask the user for their guess. Using a RandomGame
     * instance, the user's guess should be checked and the results should
     * be printed.
     * @param inScanner The scanner to scan input from.
     */
    public static void playDiceGame(Scanner inScanner) {
        System.out.print("Enter the number of faces on the die: ");
        int faces = inScanner.nextInt();
        System.out.print("Guess which side will be rolled: ");
        int guess = inScanner.nextInt();
        diceGame = new RandomGame(faces , bufferSize);
        boolean right = diceGame.checkGuess(guess);
        int correct = diceGame.getLastEvent();
        if (!right) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score += (faces / 2);
        }
        System.out.println(" Your guess: " + guess + " Correct: " + correct);

    }

    /**
     * Do a card game with the given input scanner. This takes a guess from
     * the user about the suit and rank and scores them separately. The user
     * should be able to enter the suit as a String and the rank as an int,
     * but this method should use the provided RandomGame Objects
     * for suit and rank (as in coin game). The user should then print the
     * results.
     * @param inScanner The scanner to scan input from.
     */
    public static void playCardGame(Scanner inScanner) {
        System.out.print("Guess the suit (spades, clubs, diamonds, hearts): ");
        String xx = inScanner.next();
        SuitName suitGuess; //!!!!!!!! enum
        String suitGuessprint, correctSuitprint;
        if (xx.equals("spades")) { 
            suitGuess = SuitName.spades;
        } else if (xx.equals("clubs")) {
            suitGuess = SuitName.clubs;
        } else if (xx.equals("diamonds")) {
            suitGuess = SuitName.diamonds;
        } else {
            suitGuess = SuitName.hearts;
        }

        System.out.print("Guess the rank as an int (ace is 1; king is 13): ");
        int rankGuess = inScanner.nextInt();
        boolean rightSuit = cardSuitGame.checkGuess(suitGuess.ordinal());
        boolean rightRank = cardRankGame.checkGuess(rankGuess);
        SuitName correctSuit = SuitName.values()[(cardSuitGame.getLastEvent())]; //!!!!!!!!! enum
        int correctRank = cardRankGame.getLastEvent();

        if (!rightRank && !rightSuit) {
            System.out.print("Nope!");
        } else if (rightRank && !rightSuit) {
            System.out.print("Nope!");
            score += 6;
        } else if (!rightRank && rightSuit) {
            System.out.print("Nope!");
            score += 2;
        } else {
            System.out.print("Yep!");
            score += 8;
        }

        System.out.println(" Your rank guess: " + rankGuess + " Correct: "
            + correctRank);

        System.out.println("Your suit guess: " + suitGuess + " Correct: "
            + correctSuit);

    }

    /**
     * Get the size of the random values buffer in RandomGame.
     * @return See above.
     */
    public static int getBufferSize() {
        return bufferSize;
    }

}
