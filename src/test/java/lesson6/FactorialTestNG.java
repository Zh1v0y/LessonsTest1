package lesson6;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTestNG {
    @org.testng.annotations.Test
    public void testCalculateFactorial() {
        Factorial calculator = new Factorial();
        assertEquals(calculator.calculateFactorial(0), 1);
        assertEquals(calculator.calculateFactorial(1), 1);
        assertEquals(calculator.calculateFactorial(2), 2);
        assertEquals(calculator.calculateFactorial(3), 6);
        assertEquals(calculator.calculateFactorial(4), 24);
        assertEquals(calculator.calculateFactorial(5), 120);
        assertEquals(calculator.calculateFactorial(8), 40320);
    }

    @Test
    public void testCalculateFactorialLargeNumber () {
        Factorial calculator = new Factorial();
        assertEquals(calculator.calculateFactorial(20), 2432902008176640000L);
    }

    @Test
    public void testCalculateFactorialBoundary () {
        Factorial calculator = new Factorial();
        assertEquals(calculator.calculateFactorial(0), 1); // Граничное значение 0
        assertEquals(calculator.calculateFactorial(1), 1); // Граничное значение 1
    }
}

