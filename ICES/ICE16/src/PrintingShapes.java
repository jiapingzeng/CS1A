// TODO: Don't forget to import the Scanner class for Part 5

import java.util.Scanner;

/*
 * The PrintHelper class has the methods for printing various shapes
 */
class PrintHelper {
    // Your methods to print various shapes goes here
    public void printStars(int width) {
        System.out.println("Stars:");
        int whichCol = 0;
        while (whichCol < width) {
            System.out.print("*");
            ++whichCol;
        }
        // Print just a new-line character
        System.out.println("");
    }

    public void printRectangle(int width, int height) {
        System.out.println("Rectangle:");
        // TODO: Change this method's incomplete code to use nested for-loops
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Print just a new-line character
        System.out.println("");
    }

    // TODO: Add more methods for printing shapes here:
    public void printRectangleHollow(int width, int height) {
        System.out.println("Hollow rectangle:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printLeftTriangle(int height) {
        System.out.println("Left Triangle:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class PrintingShapes extends Object {
    public static void main(String[] args) {
        // TODO: You will also add more code to this main method
        PrintHelper printer = new PrintHelper();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi");

        System.out.println("How many stars would you like to print?");
        printer.printStars(scanner.nextInt());
        scanner.nextLine();

        System.out.println("For a rectangle, how wide should it be?");
        int width1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How tall should it be?");
        int height1 = scanner.nextInt();
        printer.printRectangle(width1, height1);
        scanner.nextLine();

        System.out.println("For a hollow rectangle, how wide should it be?");
        int width2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("How tall should it be?");
        int height2 = scanner.nextInt();
        printer.printRectangleHollow(width2, height2);
        scanner.nextLine();

        System.out.println("For a left triangle, how tall should it be?");
        printer.printLeftTriangle(scanner.nextInt());
    }
}