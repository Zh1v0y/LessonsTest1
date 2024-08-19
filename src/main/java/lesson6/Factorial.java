package lesson6;

import java.util.stream.LongStream;

public class Factorial {
    public static void main(String[] args) {
        Integer n = 20;
        System.out.println("Факториал числа " + n + " равен " + getFactorial(n));
    }

    public static long getFactorial(Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException("Входные данные должны быть неотрицательным целым числом!");
        }
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> {
                    // Проверка на переполнение
                    if (x > Long.MAX_VALUE / y) {
                        throw new ArithmeticException("Результат слишком большой для типа long!");
                    }
                    return x * y;
                });
    }
}
