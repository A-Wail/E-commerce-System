package business;

import interfaces.Shippable;
import shopping.ShoppingCart;

public class ShippingItem implements Shippable {
    private final ShoppingCart cartItem;

    public ShippingItem(ShoppingCart cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String getName() {
        return cartItem.getQuantity() + "x " + cartItem.getProduct().getName();
    }

    @Override
    public double getWeight() {
        Shippable product = (Shippable)cartItem.getProduct();
        return product.getWeight() ;
    }
}
