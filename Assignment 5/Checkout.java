import java.util.Vector;

public class Checkout {
    private Vector<DessertItem> items;

    public Checkout() {
        this.items = new Vector<>();
    }

    public void enterItem(DessertItem item) {
        this.items.add(item);
    }

    public int numberOfItems() {
        return this.items.size();
    }

    public void clear() {
        this.items.clear();
    }

    public int totalCost() {
        int total = 0;
        for (DessertItem item: items) {
            total += item.getCost();
        }
        return total;
    }

    public int totalTax() {
        return (int) Math.round(totalCost() * DessertShoppe.getTaxRate());
    }

    @Override
    public String toString() {
        String string = DessertShoppe.getStoreName() + " Dessert Shoppe:" + "\n";
        for (DessertItem item: items) {
            string += DessertShoppe.cents2dollarsAndCents(item.getCost()) + "\t" + item.getName();
            if (item instanceof Candy) {
                string += "(" + ((Candy) item).getWeightLbs() + " lbs. @ "
                        + DessertShoppe.cents2dollarsAndCents(((Candy) item).getPricePerLbs()) + " /lb.)";
            } else if (item instanceof Cookie) {
                string += "(" + ((Cookie) item).getNumber() + " @ "
                        + DessertShoppe.cents2dollarsAndCents(((Cookie) item).getPricePerDozen()) + " /dz.)";
            } else if (item instanceof Sundae) {
                string += " with " + ((Sundae) item).getToppingName();
            }
            string += "\n";
        }
        // Tax
        string += "\n" + "Tax" + "\t\t\t" + DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n";
        // Total
        string += "Total Cost" + "\t" + DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()) + "\n";

        return string;
    }
}
