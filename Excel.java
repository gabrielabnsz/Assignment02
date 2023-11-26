import java.util.ArrayList;
import java.util.Collections;

public class Excel {
    private ArrayList<Double> numbers = new ArrayList<>();

    // Constructor that takes input and stores numbers in a list
    public Excel(String input) {
        String[] numStrings = input.split(" ");
        for (String numStr : numStrings) {
            try {
                double num = Double.parseDouble(numStr);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing number: " + numStr);
            }
        }
    }

    // Calculating the sum
    public double findTotal() {
        double total = 0.0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }

    // Calculating the average
    public double findAverage() {
        double total = findTotal();
        return total / numbers.size();
    }

    // Finding the maximum number
    public double findMaximum() {
        return Collections.max(numbers);
    }

    // Finding the minimum number
    public double findMinimum() {
        return Collections.min(numbers);
    }
}