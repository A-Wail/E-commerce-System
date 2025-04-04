package shopping;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ShoppingCart> items = new ArrayList<>();

    public void add(Product product, int quantity){
        if (quantity <= 0 )
            throw new IllegalArgumentException("Invalid, Quantity must greater than zero !!");
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("Not enough amount of this Product !!");
        // Check if product already exist in  Cart
        for (ShoppingCart item : items) {
                if (item.getProduct().equals(product)) {
                    throw new IllegalArgumentException("Product already in cart");
        }

            }
        items.add(new ShoppingCart(product,quantity));
        }

    public List<ShoppingCart> getItems() {
        return items;
    }
    public boolean isEmpty(){ return items.isEmpty();}


}

