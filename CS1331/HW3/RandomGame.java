import java.util.Random;

/**
 * This class manages the actual guessing game functionality, including
 * creating and updating the array containing the preselected random values and
 * checking if the user's guesses are correct.
 */
public class RandomGame {

    private Random random;
    private int maxGuessValue;
    private int o = 0;
    private int bufferSize;

    // Buffer of precommitted values to ensure fairness.
    private int[] randomValues;

    /**
     * Make a RandomGame with the given maximum value.
     * Do not modify this constructor!
     * @param max The maximum value this RandomGame will process.
     * @param bufferSize The size of the buffer this RandomGame uses.
     */
    public RandomGame(int max, int bufferSize) {
        random = new Random();
        maxGuessValue = max;
        randomValues = new int[bufferSize];
        this.bufferSize = bufferSize;
        generateEvents();
    }

    /**
     * Reload the buffer array. This method should fill the random values
     * array with integers in the range of [1, maxGuessValue] (between
     * 1 and maxGuessValue including 1 and maxGuessValue).
     */
    private void generateEvents() {
        for (int i = 1; i < bufferSize; i++) {
            int x = 1 + random.nextInt(maxGuessValue);
            randomValues[i - 1] = x;
        }

    }

    /**
     * Check if a guess is correct. This method takes in an integer (guess)
     * and should return if the input matches the value in random values
     * at the stored index and then increment that index. If all the values in
     * the buffer have been used the buffer should be generated again.
     * @param guess The guess the user has made.
     * @return If the input matches the current int in the random values buffer.
     */
    public boolean checkGuess(int guess) {
        return (guess == randomValues[o++]);
    }

    /**
     * Get the value of the random buffer. This method should return the last
     * value from randomValues used.
     * @return The value of the random buffer.
     */
    public int getLastEvent() {
        return randomValues[o - 1];
    }

}
