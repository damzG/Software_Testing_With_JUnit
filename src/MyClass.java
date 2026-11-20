public class MyClass {

    public int multiply(int x, int y) {

        if (x >= 1000 || y >= 1000) {
            throw new IllegalArgumentException(
                "Both inputs must be less than 1000"
            );
        }

        return x * y;
    }
}