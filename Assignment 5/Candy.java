public class Candy extends DessertItem {
    private double weightLbs;
    private int pricePerLbs;

    public Candy(String name, double weightLbs, int pricePerLbs) {
        super(name);
        this.weightLbs = weightLbs;
        this.pricePerLbs = pricePerLbs;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public int getPricePerLbs() {
        return pricePerLbs;
    }

    public int getCost() {
        double total = weightLbs * pricePerLbs;
        return (int) Math.round(total);
    }
}
