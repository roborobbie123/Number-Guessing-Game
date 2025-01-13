import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I am thinking of a number between 1 and 100.");
        System.out.println("Select a difficulty below to get started!");
        System.out.println("--------------------------------------");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");

        int chances = 0;
        while(true) {

            int difficulty = 0;
            boolean check = false;

            while(!check) {
                try {
                    difficulty = scanner.nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid number!");
                    scanner.next();
                    continue;
                }
            }
            switch (difficulty) {
                case 1:
                    chances = 10;
                    System.out.println("Difficulty set to Easy");
                    break;
                case 2:
                    chances = 5;
                    System.out.println("Difficulty set to Medium");
                    break;
                case 3:
                    System.out.println("Difficulty set to Hard");
                    chances = 3;
                    break;
                default:
                    System.out.println("Enter a number between 1 and 3");
                    continue;
            }
            break;
        }

        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int defaultChances = chances;

        while(true) {
            System.out.println("Guess: ");
            int guess = 0;
            boolean check = false;
            while(!check) {
                try {
                    guess = scanner.nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid number!");
                    scanner.next();
                    continue;
                }
            }
            if(chances == 1) {
                System.out.println("Out of guesses! Please restart the game!");
                break;
            }
            if(guess == number) {
                System.out.println("Congratulations! You have guessed it!");
                System.out.println("Number of guesses: " + (defaultChances - chances));
                break;
            }
            if(guess > number) {
                System.out.println("Your number is too high!");
                chances--;
                continue;
            }
            if(guess < number) {
                System.out.println("Your number is too low!");
                chances--;
                continue;
            }

        }

    }
}
