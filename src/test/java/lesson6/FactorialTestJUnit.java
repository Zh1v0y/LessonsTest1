package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

class MainTest {

    // Тест на случай, когда входное значение равно null
    @ParameterizedTest
    @NullSource
    void testGetFactorialWithNullInput(Integer input) {
        // Проверка на null
        Assertions.assertThrows(NullPointerException.class, () -> Factorial.getFactorial(input));
    }

    // Метод, который предоставляет параметры для положительных тестов
    private static Stream<Object[]> factorialProvider() {
        return Stream.of(
                new Object[]{0, 1},                         // 0! = 1
                new Object[]{1, 1},                         // 1! = 1
                new Object[]{19, 121645100408832000L},      // 19! = 121645100408832000
                new Object[]{20, 2432902008176640000L}      // 20! = 2432902008176640000
        );
    }

    @ParameterizedTest
    @MethodSource("factorialProvider")
    void testGetFactorial(Integer input, long expected) {
        long result = Factorial.getFactorial(input);
        Assertions.assertEquals(expected, result);
    }

    // Тест на некорректные входные данные
    @Test
    void testGetFactorialWithNegativeInput() {
        int input = -1;
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Factorial.getFactorial(input));

        String expectedMessage = "Входные данные должны быть неотрицательным целым числом!";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    // Метод, который предоставляет параметры для отрицательных тестов (тест на символы как входные значения)
    private static Stream<String> nonIntegerInputProvider() {
        return Stream.of("a", "@", "1.5");
    }

    @ParameterizedTest
    @MethodSource("nonIntegerInputProvider")
    void testGetFactorialWithNonIntegerInput(String input) {
        Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            Factorial.getFactorial(Integer.parseInt(input)); // Попытка преобразовать строку в целое число
        });

        Assertions.assertEquals("For input string: \"" + input + "\"", exception.getMessage());
    }

    // Тест на слишком большие значения
    @Test
    void testGetFactorialWithLargeInput() {
        int largeInput = 21;
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> Factorial.getFactorial(largeInput));

        String expectedMessage = "Результат слишком большой для типа long!";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    // Метод, который предоставляет параметры для отрицательных тестов (тест на неправильные типы)
    private static Stream<Object> wrongTypeInputProvider() {
        return Stream.of("string", true, 3.14);
    }

    @ParameterizedTest
    @MethodSource("wrongTypeInputProvider")
    void testGetFactorialWithString(Object input) {
        Assertions.assertThrows(ClassCastException.class, () -> Factorial.getFactorial((Integer) input));
    }
}