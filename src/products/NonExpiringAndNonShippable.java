package products;

import entity.Product;

//Products like Mobile and Mobile scratch cards use this class
public class NonExpiringAndNonShippable extends Product {

    public NonExpiringAndNonShippable(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean doesExpire() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }


}
