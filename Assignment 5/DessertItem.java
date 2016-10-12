public abstract class DessertItem {
    private String name;

    public DessertItem() {}

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getCost();
}