public class Arrays_With_Loops extends Object {
    public static void main(String[] args) {
        // First: Create an array
        double[] arr = new double[5];
        // Second: Use a while loop to set the array elements' values
        int i = 0;
        while (i < arr.length) {
            arr[i] = i+1;
            i++;
        }
        // Third: Use a for loop to print out the array
        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}