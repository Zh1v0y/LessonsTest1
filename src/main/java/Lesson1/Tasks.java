package Lesson1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Tasks {
    public void printThreeWords() {
        System.out.println("\nTASK 1");
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign(int a, int b) {
        System.out.println("\nTASK 2");
        int sum = a + b;
        System.out.println((sum >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    public void printColor(int value) {
        System.out.println("\nTASK 3");
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers(int a, int b) {
        System.out.println("\nTASK 4");
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    public boolean checkSumInRange(int a, int b) {
        System.out.println("\nTASK 5");
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void checkNumberSign(int number) {
        System.out.println("\nTASK 6");
        System.out.println((number >= 0) ? "Число положительное" : "Число отрицательное");
    }

    public boolean isNegativeNumber(int number) {
        System.out.println("\nTASK 7");
        return number < 0;
    }

    public void printStringMultipleTimes(String text, int count) {
        System.out.println("\nTASK 8");
        IntStream.range(0, count).forEach(value -> System.out.println(text));
    }

    public boolean isLeapYear(int year) {
        System.out.println("\nTASK 9");
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int[] swapZerosAndOnes(int[] array) {
        System.out.println("\nTASK 10");
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        return array;
    }

    public int[] fillArrayWithNumbers(int length) {
        System.out.println("\nTASK 11");
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public int[] multiplyNumbersLessThanSix(int[] array) {
        System.out.println("\nTASK 12");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    public void fillDiagonalElementsWithOnes(int size) {
        System.out.println("\nTASK 13");
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        Arrays.stream(array).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public int[] createArrayWithInitialValue(int len, int initialValue) {
        System.out.println("\nTASK 14");
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}
