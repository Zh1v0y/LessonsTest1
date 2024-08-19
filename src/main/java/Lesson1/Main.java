package Lesson1;

import java.util.Arrays;

public class Main {

    private static final int[] ARRAY_TASK_10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    private static final int[] ARRAY_TASK_12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

    public static void main(String[] args) {
        Tasks tasksSolver = new Tasks();

        tasksSolver.printThreeWords();
        tasksSolver.checkSumSign(5, -10);
        tasksSolver.printColor(-15);
        tasksSolver.compareNumbers(3,9);
        System.out.println(tasksSolver.checkSumInRange(4,17));
        tasksSolver.checkNumberSign(-12);
        System.out.println(tasksSolver.isNegativeNumber(14));
        tasksSolver.printStringMultipleTimes("Hello ASTON!", 3);
        System.out.println(tasksSolver.isLeapYear(2024));
        System.out.println(Arrays.toString(tasksSolver.swapZerosAndOnes(ARRAY_TASK_10)));
        System.out.println(Arrays.toString(tasksSolver.fillArrayWithNumbers(100)));
        System.out.println(Arrays.toString(tasksSolver.multiplyNumbersLessThanSix(ARRAY_TASK_12)));
        tasksSolver.fillDiagonalElementsWithOnes(11);
        System.out.println(Arrays.toString(tasksSolver.createArrayWithInitialValue(16, 23)));
    }
}
