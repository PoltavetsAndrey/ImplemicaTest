import java.math.BigInteger;

public class Main {

    BigInteger factorial = new BigInteger("1");

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        int factorialNumber = 100; // Factorial number n
        calculateFactorial(factorialNumber);
        System.out.println("Sum of the digits in the number " + factorialNumber + "! = " +
                calculateSumOfDigits());
    }

    private void calculateFactorial(int factorialNumber) {
        for (int i = 1; i <= factorialNumber; i++) {
            // Multiply by the next number
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
    }

    // Calculate sum of digits factorial
    private int calculateSumOfDigits() {
        // Let's convert from BigInteger to String
        String bufer = String.valueOf(factorial);
        int sumOfDigits = 0; // Sum of digits factorial
        for (int i = 0; i < bufer.length(); i++) {
            sumOfDigits = sumOfDigits +
                    Character.getNumericValue(bufer.charAt(i)); // Let's convert from char to int
        }
        return sumOfDigits;
    }
}
