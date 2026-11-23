import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class BackToBackTest {

    static ConsumptionA a = new ConsumptionA();
    static ConsumptionB b = new ConsumptionB();

    // The inputs. There are no expected results: A and B are compared with each other.
    static Stream<Arguments> inputs() {
        List<Arguments> inputs = new ArrayList<>();

        // Six inputs chosen on purpose
        inputs.add(Arguments.of(1000, 1500, 30.0));
        inputs.add(Arguments.of(1000, 1340, 25.0));
        inputs.add(Arguments.of(1000, 1000, 30.0));
        inputs.add(Arguments.of(1000, 900, 30.0));
        inputs.add(Arguments.of(1000, 1500, 0.0));
        inputs.add(Arguments.of(1000, 1500, -5.0));

        // 300 random inputs. The 42 means you get the same 300 every time you run.
        Random random = new Random(42);
        for (int i = 0; i < 300; i++) {
            int previousKm = random.nextInt(200000);
            int currentKm = previousKm + random.nextInt(1001);
            double litres = Math.round(random.nextDouble() * 8000) / 100.0;
            inputs.add(Arguments.of(previousKm, currentKm, litres));
        }
        return inputs.stream();
    }

    @ParameterizedTest(name = "previous={0} current={1} litres={2}")
    @MethodSource("inputs")
    void aAndBGiveTheSameAnswer(int previousKm, int currentKm, double litres) {
        String answerA = run(true, previousKm, currentKm, litres);
        String answerB = run(false, previousKm, currentKm, litres);
        assertEquals(answerA, answerB, "A and B disagree. A says " + answerA + ", B says " + answerB);
    }

    // Runs A or B, and turns an exception into text so that it can be compared too.
    static String run(boolean useA, int previousKm, int currentKm, double litres) {
        try {
            double answer = useA ? a.consumption(previousKm, currentKm, litres)
                                 : b.consumption(previousKm, currentKm, litres);
            return String.valueOf(answer);
        } catch (IllegalArgumentException e) {
            return "IllegalArgumentException";
        }
    }
}
