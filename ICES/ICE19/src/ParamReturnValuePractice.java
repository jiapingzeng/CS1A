class PrintHelper extends Object {
    public double[] getTemperatures() {
        double[] temps = new double[7];
        temps[0] = 5.6;
        temps[1] = 2;
        for (int i = 2; i < temps.length; i++)
            temps[i] = (i + 1) * 3 + 17;
        return temps;
    }

    public void printArray(double[] arr) {
        for (double d : arr) {
            System.out.println(d);
        }
    }

    public double averageArray(double[] arr) {
        double sum = 0;
        for (double d : arr) {
            sum += d;
        }
        return sum / arr.length;
    }

    public double[] clonePlusTwo(double[] arr) {
        double[] clone = arr.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] += 2;
        }
        return clone;
    }

    public void upByTwo(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 2;
        }
    }

}

public class ParamReturnValuePractice extends Object {
    public static void main(String[] args) {
        PrintHelper ph = new PrintHelper();

        double[] ts = new double[3];
        ts = ph.getTemperatures();
        System.out.println("Temperatures:");
        ph.printArray(ts);
        ph.upByTwo(ts);
        System.out.println("New Temperatures:");
        ph.printArray(ts);
        double[] clone2 = ph.clonePlusTwo(ts);
        ts[0] = 88;
        System.out.println("Cloned Temperatures");
        ph.printArray(clone2);
        System.out.println("Average of Cloned Temperatures " + ph.averageArray(clone2));

        double[] arr = new double[5];
        int i = 0;
        while (i < arr.length) {
            arr[i] = i + 6;
            i++;
        }
        for (i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}