package shopping;

import entity.Product;

public class ShoppingCart {
    private Product product;
    private int quantity;

    public ShoppingCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity ;
    }
}
