import business.CheckoutSystem;
import business.ShippingService;
import entity.Customer;
import entity.Product;
import products.ExpiringAndNonShippable;
import products.ExpiringAndShippable;
import products.NonExpiringAndNonShippable;
import products.NonExpiringAndShippable;
import shopping.Cart;
import shopping.ShoppingCart;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product cheese = new ExpiringAndShippable("Cheese", 100, 10, 0.4,
                LocalDate.now().plusDays(7));
        Product biscuits = new ExpiringAndNonShippable("Biscuits", 150, 3,
                LocalDate.now().plusDays(28));

        // Create customer
        Customer customer = new Customer("John Doe", 50000);

        // Create cart
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        // Create checkout system
        ShippingService shippingService = new ShippingService();
        CheckoutSystem checkoutSystem = new CheckoutSystem(shippingService);

        // Perform checkout
        checkoutSystem.checkout(customer, cart);
    }
}