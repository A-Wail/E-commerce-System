package products;

import entity.Product;
import interfaces.Shippable;

//Products like TV use this class
public class NonExpiringAndShippable extends Product implements Shippable {
    private double weight;

    public NonExpiringAndShippable(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public boolean doesExpire() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
}
