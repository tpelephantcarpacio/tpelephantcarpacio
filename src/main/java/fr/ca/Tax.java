package fr.ca;

public enum Tax {
    DE(1.19), DK(1.25), FR(1.196);

    private final double tax;

    Tax(final double tax) {
        this.tax = tax;
    }

    public double value() {
        return this.tax;
    }
}
