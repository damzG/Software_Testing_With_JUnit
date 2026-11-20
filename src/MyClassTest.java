import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyClassTest {

    @Test
void multiplyBasic() {
    MyClass tester = new MyClass();
    assertEquals(5, tester.multiply(1, 5));
}

@Test
void multiplyNegative() {
    MyClass x = new MyClass();
    assertEquals(-10, x.multiply(-2, 5));
}

@Test
void multiplyBy0() {
    MyClass x = new MyClass();
    assertEquals(0, x.multiply(0, 0));
}

@Test
void multiplyXTooLarge() {
    MyClass tester = new MyClass();
    assertThrows(IllegalArgumentException.class,
        () -> tester.multiply(1000, 5));
}

@Test
void multiplyYTooLarge() {
    MyClass tester = new MyClass();
    assertThrows(IllegalArgumentException.class,
        () -> tester.multiply(5, 1000));
}
}

