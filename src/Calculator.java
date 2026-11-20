public class Calculator {

  public int add(int a, int b) {
    if (a < 0 || b < 0) {
    throw new IllegalArgumentException("Negative numbers not allowed");
}
    return a + b;
}

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
