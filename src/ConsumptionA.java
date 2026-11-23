public class ConsumptionA {

    public double consumption(int previousKm, int currentKm, double litres) {
        if (currentKm <= previousKm) {
            throw new IllegalArgumentException("Current reading must be greater than previous reading");
        }
        double per100km = litres * 100.0 / (currentKm - previousKm);
        return Math.round(per100km * 10) / 10.0;
    }
}
