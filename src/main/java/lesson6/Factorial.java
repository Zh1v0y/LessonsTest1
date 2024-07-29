package lesson6;

public class Factorial {
    public static void main(String[] args) {
        int number = 8; // Задать число
        long factorial = calculateFactorial(number);
        System.out.println("Факториал " + number + " равен " + factorial);
    }

    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
