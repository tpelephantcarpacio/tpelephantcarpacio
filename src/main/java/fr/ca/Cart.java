package fr.ca;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Item, Integer> products = new HashMap<Item, Integer>();

    public void addProduct(final Item item, final int quantity) {
        products.put(item, quantity);
    }

    public int countProducts() {
        return products.keySet().size();
    }

    public double computeHtPrice() {
        return products
                .entrySet()
                .stream()
                .map(x -> x.getKey().getPrice() * x.getValue())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private double computeReduction(final double priceWithoutTax) {

        if (priceWithoutTax >= 1000 && priceWithoutTax < 5000) {
            return priceWithoutTax * 0.97d;
        } else if (priceWithoutTax >= 5000 && priceWithoutTax < 7000) {
            return priceWithoutTax * 0.95d;
        } else if (priceWithoutTax >= 7000 && priceWithoutTax < 10000) {
            return priceWithoutTax * 0.93d;
        }
        return priceWithoutTax;
    }

    public double computeTotalPrice(final Tax tax) {
        return computeReduction(computeHtPrice()) * tax.value();
    }
}
