// PUT YOUR NAMES HERE <---<<<
// BIT115 Fall 2015
// Assignment 4 ADVANCED: Guessing Game
// The 'METHODS' File

// You may use the nested comments below as hints only. Remember, there is no one right or wrong way 
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.*;

public class GuessingGame extends Object {
    // List any instance variables here (e.g., userGuess, numberChoice)

    Random randomNumberGenerator = new Random();
    Scanner keyboard = new Scanner(System.in);
    int secretNumber = this.GetRandomNumber();

    // Create an array to hold 5 guesses (e.g., userGuess)
    int[] userGuess = new int[5];
    int numberChoice = 0;

    // If you need to get a number for the user to userGuess (randomly),
    // call the method below and it will create one for you.
    // The number may be as low as 0, and as high as 15
    // (This will be 16 separate numbers that the user might try to userGuess)
    // Of course, you will have to create a variable space to hold this number
    // when it is returned (e.g., secretNumber)
    public int GetRandomNumber() {
        return randomNumberGenerator.nextInt(16);
    }

    // You may want to create a method that will display the welcome message and rules (e.g., welcome)
    public void welcome() {
        System.out.println("Welcome, new player! Let's play the guessing game!");
        System.out.println();
        System.out.println("Rules of the guessing game:");
        System.out.println();
        System.out.println("1. You've got 5 guesses to guess my secret number");
        System.out.println("2. The number is a whole number that's between 0 and 15 (inclusive at both ends)");
        System.out.println("3. I'll give you hints about the number, if you don't guess right");
        System.out.println();
        System.out.println("Ok, I just thought of a new number for you to guess");
        System.out.println();
    }

    // You may want to create a method (e.g., isGuessNum) that will check to see that the numbered entered is a whole
    // number, place it into a variable space (e.g., userGuess), and then handle all
    // the various options regarding that number: has it been guessed before?; is it the
    // secret number?; if it isn't the secret number store it in the proper location for
    // cross checking; display messages regarding the number of guesses made, incorrect
    // userGuess, guesses remaining, secret number if all guesses used up, error handling, etc.
    public void isGuessNum(int g) {
        if (isValidGuess(g)) {
            if (isGuessedPreviously(g)) {
                System.out.println("You've already guessed " + g);
            } else {
                System.out.println("I'm sorry, but my secret number is not " + g);
                storeGuess(g);
            }
            printPreviousGuess();
            System.out.println("You have " + (5 - numberChoice) + " guessed left");
            System.out.println("Your next guess?");
            System.out.println();
        }
    }

    // You may want to create a method to print the user's previous userGuess
    public void printPreviousGuess() {
        System.out.print("So far, you've guessed:");
        for (int i = 0; i < numberChoice; i++) {
            System.out.print(" " + userGuess[i]);
        }
        System.out.println();
    }

    // You may want to create a method to store the user's guesses in the 5 elements of the array
    public void storeGuess(int g) {
        userGuess[numberChoice] = g;
        numberChoice++;
        giveHint(g);
    }

    // You may want to create a boolean method to check that the user's userGuess is within range (between 0 and 15)
    // and will return true if it is
    public boolean isValidGuess(int g) {
        if (g >= 0 && g <= 15) {
            return true;
        }
        return false;
    }

    // You may want to create a boolean method to see if the number has been guessed previously
    // and will return true if it has
    public boolean isGuessedPreviously(int g) {
        for (int i : userGuess) {
            if (g == i) {
                return true;
            }
        }
        return false;
    }

    // You may want to create a boolean method to see if the number matches the secret number
    // and will return true if it does or false if it doesn't
    public boolean isSecretNumber(int g) {
        if (secretNumber == g) {
            return true;
        }
        return false;
    }

    // You may want to create a method to give a hint about the number guessed (e.g., "My secret
    // number is GREATER than " or "My secret number is LESS than ")
    public void giveHint(int g) {
        // s==g won't happen because isSecretNumber is called before this
        if (secretNumber < g) {
            System.out.println("My secret number is less than " + g);
        } else {
            System.out.println("My secret number is greater than " + g);
        }
    }

    // You may want to create a method (e.g., playGame) that will check if the user wants to play again
    // (1 for 'yes', 0 for 'no') and incorporate the proper functionality depending on the user's choice ( 1 or 0)

    public void PlayGuessingGame() {

        System.out.println("Hello!");              // You might call a welcome() method here instead
        welcome();

        // You might create a loop here that will check numberGuesses 5 times and print the userGuess number and call the
        // pertinent method (e.g., isGuessNum)
        while (keyboard.hasNextInt() && numberChoice < 5) {
            System.out.println();
            int guess = keyboard.nextInt();
            if (isSecretNumber(guess)) {
                System.out.println("Great guess!!! That's my number!! Winner!!");
                System.out.println();
                break;
            } else {
                isGuessNum(guess);
            }
            keyboard.nextLine();
        }
        // TODO check this
        // TODO change variable names
        if (numberChoice >= 5) {
            System.out.println("You're out of guesses!");
        }
        // You might call and capture results from method (e.g., playGame) to see if user wants to play again and if
        // so return it. Example: int playAgain = this.playGame();

        return; // if you want to end the game early & go directly back to main,
        // you can use a "return;" statement like this one (e.g., return playAgain;)
    }

}