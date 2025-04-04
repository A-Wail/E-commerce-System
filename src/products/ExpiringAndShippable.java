package products;

import entity.Product;
import interfaces.Shippable;

import java.time.LocalDate;
//Products like Cheese use this class
public class ExpiringAndShippable extends Product implements  Shippable {
    private LocalDate expiryDate;
    private double weight;



    public ExpiringAndShippable(String name, double price, int quantity, double weight , LocalDate expiryDate) {
        super(name, price, quantity);

        this.weight = weight;

        this.expiryDate = expiryDate;

    }



    @Override
    public double getWeight() {
        return weight;
    }



    @Override
    public boolean doesExpire() {
        return true;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

}
