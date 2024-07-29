package lesson6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTestJUnit {
    @Test
    public void testCalculateFactorial() {
        Factorial calculator = new Factorial();
        assertEquals(1, calculator.calculateFactorial(0));
        assertEquals(1, calculator.calculateFactorial(1));
        assertEquals(2, calculator.calculateFactorial(2));
        assertEquals(6, calculator.calculateFactorial(3));
        assertEquals(24, calculator.calculateFactorial(4));
        assertEquals(120, calculator.calculateFactorial(5));
        assertEquals(40320, calculator.calculateFactorial(8));

    }

    @Test
    public void testCalculateFactorialBoundary() {
        Factorial calculator = new Factorial();
        assertEquals(1, calculator.calculateFactorial(0)); // Граничное значение 0
        assertEquals(1, calculator.calculateFactorial(1)); // Граничное значение 1
    }
}
