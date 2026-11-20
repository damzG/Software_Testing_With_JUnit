import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator c = new Calculator();
        assertEquals(5, c.add(2, 3));
    }

    @Test
    void testDivide() {
        Calculator c = new Calculator();
        assertEquals(2, c.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.divide(4, 0));
    }

    @Test 
    void testAddNegative(){
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.add(-23, -9));
    }

    @Test
void testAddNegativeSecondArgument() {
    Calculator c = new Calculator();
    assertThrows(IllegalArgumentException.class,
        () -> c.add(23, -9));
}
}
