import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int n = inputAmountBracket();
        System.out.println("Number of correct bracket expressions, containing " +
                        n  + " opening " + "and " + n +
                        " closing brackets = " + calculation(n));
    }

    // Entering from keyboard the number of pairs of brackets
    private int inputAmountBracket() {
        int amountBracket = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the number of pairs of brackets > 0");
            amountBracket = scanner.nextInt();
        } while (amountBracket < 1);
        return amountBracket;
    }

    // Calculation of Katalan number
    private int calculation(int n) {
        int numberKatalan = 0;
        numberKatalan = factorial(2 * n) / (factorial(n) * factorial(n + 1));
        return numberKatalan;
    }

    // Factorial calculation
    private int factorial(int x) {
        int factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
