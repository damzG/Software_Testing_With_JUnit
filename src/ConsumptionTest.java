import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsumptionTest {

    @Test
    void roundsToOneDecimalPlace() {
        ConsumptionA b = new ConsumptionA();
        // 25 litres over 340 km is 7.3529... litres per 100 km.
        // The specification says "rounded to one decimal place", so 7.4.
        assertEquals(7.4, b.consumption(1000, 1340, 25.0), 0.001);
    }

    @Test
    void sameReadingTwiceIsNotValid() {
        ConsumptionA b = new ConsumptionA();
        // My reading of the specification: The current reading must be grater than the previous reading
        assertThrows(IllegalArgumentException.class,
                     () -> b.consumption(1000, 1000,  30.0));
    }
}
