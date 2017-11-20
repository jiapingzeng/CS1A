import java.util.Scanner;

public class ICE17_Part_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[5];
        int i = 0;
        while (i < arr.length) {
            System.out.println("Enter grade:");
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                for (int j = 0; j < arr.length; j++) {
                    if (input == arr[j]) {
                        System.out.println("Grade found at index " + j);
                        break;
                    }
                }
                arr[i] = input;
                scanner.nextLine();
            }
            i++;
        }
        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        double total = 0;
        for (i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println("Average:");
        System.out.println(total/arr.length);
    }
}
