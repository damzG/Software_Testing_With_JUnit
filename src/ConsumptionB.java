public class ConsumptionB {

    public double consumption(int previousKm, int currentKm, double litres) {
        if (currentKm < previousKm) {
            throw new IllegalArgumentException("Odometer cannot go backwards");
        }
        int distance = currentKm - previousKm;
        double per100km = (litres / distance) * 100;
        return (int) (per100km * 10) / 10.0;
    }
}