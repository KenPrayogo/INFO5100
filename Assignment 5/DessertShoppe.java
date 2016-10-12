public final class DessertShoppe {
    private static final String storeName = "Sweet Cheezus";
    private static final double taxRate = 0.0975;

    public static String getStoreName() {
        return storeName;
    }

    public static double getTaxRate() {
        return taxRate;
    }

    public static String cents2dollarsAndCents(int cents) {
        return Double.toString(cents / 100.0);
    }
}
