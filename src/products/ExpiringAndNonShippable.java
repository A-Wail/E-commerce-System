package products;


import entity.Product;

import java.time.LocalDate;


//Products like Biscuits use this class
public class ExpiringAndNonShippable extends Product {
    private LocalDate expiryDate;

    public ExpiringAndNonShippable(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }


    @Override
    public boolean doesExpire() {
        return true;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }


}
