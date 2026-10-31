package ChatGpt;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(100) + 1; // generate a random number between 1 and 100
        int guess;
        int attempts = 0;
        
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
        
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < number) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > number) {
                System.out.println("Your guess is too high. Try again.");
            }
        } while (guess != number);
        
        System.out.println("Congratulations, you guessed the number in " + attempts + " attempts!");
    }
}
