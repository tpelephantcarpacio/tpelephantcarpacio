package fr.ca;

public class Item {
    private final String label;

    private final double price;

    public Item(final String label, final double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return this.label;
    }

    public double getPrice() {
        return this.price;
    }
}
