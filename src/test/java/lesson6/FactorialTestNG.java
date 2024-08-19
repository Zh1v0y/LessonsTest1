package lesson6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTestNG {

    // Тест на случай, когда входное значение равно null
    @Test(expectedExceptions = NullPointerException.class)
    public void testGetFactorialWithNullInput() {
        Factorial.getFactorial(null);
    }

    // Метод, который предоставляет параметры для положительных тестов
    @DataProvider(name = "factorialProvider")
    public Object[][] factorialProvider() {
        return new Object[][]{
                {0, 1},                         // 0! = 1
                {1, 1},                         // 1! = 1
                {19, 121645100408832000L},      // 19! = 121645100408832000
                {20, 2432902008176640000L}      // 20! = 2432902008176640000
        };
    }

    @Test(dataProvider = "factorialProvider")
    public void testGetFactorial(Integer input, long expected) {
        long result = Factorial.getFactorial(input);
        assertEquals(result, expected);
    }

    // Тест на некорректные входные данные
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetFactorialWithNegativeInput() {
        int input = -1;
        Factorial.getFactorial(input); // Исключение будет выброшено
    }

    // Тест на символы как входные значения
    @DataProvider(name = "nonIntegerInputProvider")
    public Object[] nonIntegerInputProvider() {
        return new Object[]{"a", "@", "1.5"};
    }

    @Test(dataProvider = "nonIntegerInputProvider", expectedExceptions = NumberFormatException.class)
    public void testGetFactorialWithNonIntegerInput(String input) {
        Factorial.getFactorial(Integer.parseInt(input)); // Попытка преобразовать строку в целое число
    }

    // Тест на слишком большие значения
    @Test(expectedExceptions = ArithmeticException.class)
    public void testGetFactorialWithLargeInput() {
        int largeInput = 21;
        Factorial.getFactorial(largeInput); // Исключение будет выброшено
    }

    // Метод, который предоставляет параметры для отрицательных тестов (тест на неправильные типы)
    @DataProvider(name = "wrongTypeInputProvider")
    public Object[] wrongTypeInputProvider() {
        return new Object[]{"string", true, 3.14};
    }

    @Test(dataProvider = "wrongTypeInputProvider", expectedExceptions = ClassCastException.class)
    public void testGetFactorialWithString(Object input) {
        Factorial.getFactorial((Integer) input); // Исключение будет выброшено
    }
}