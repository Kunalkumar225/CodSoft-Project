import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;
        int totalRounds = 0;
        int totalWins = 0;

        while (playAgain) {
            totalRounds++;
            int randomNumber = generateRandomNumber(RANGE_MIN, RANGE_MAX);
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ". You have " + MAX_ATTEMPTS + " attempts.");

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
                    System.out.println("Please guess a number within the specified range.");
                    attempt--; // Do not count this attempt
                    continue;
                }

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    totalWins++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Your score: " + totalWins + "/" + totalRounds);
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}