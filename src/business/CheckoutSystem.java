package business;

import entity.Customer;
import entity.Product;
import interfaces.Shippable;
import products.ExpiringAndShippable;
import shopping.Cart;
import shopping.ShoppingCart;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutSystem {
    private static final double SHIPPING_FEE_PER_KG = 30;
    private ShippingService shippingService;

    public CheckoutSystem(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        // 1- Validate the cart and products
        validateCheckout(customer, cart);

        // 2- Calculate costs
        double subtotal = calculateSubtotal(cart);
        double shippingFee = calculateShippingFee(cart);
        double totalAmount = subtotal + shippingFee;

        // 3- Process payment
        processPayment(customer, totalAmount);

        // 4- Update inventory
        updateInventory(cart);

        // 5- Handle shipping
        handleShipping(cart);

        // 6-Print receipt
        printReceipt(cart, subtotal, shippingFee, totalAmount, customer);

    }

    private void validateCheckout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("تنبيه: العربة فارغة!");
            throw new IllegalStateException("Cann't checkout with empty cart !!");
        }

        for (ShoppingCart item : cart.getItems()) {
            Product product = item.getProduct();

            // Check for expired product
            if (product.doesExpire() && product instanceof ExpiringAndShippable expiringProduct) {
                if (expiringProduct.isExpired()) {
                    throw new IllegalStateException(product.getName() + " is expired");
                }
            }

            // Check stock availability
            if (item.getQuantity() > product.getQuantity()) {
                throw new IllegalStateException(product.getName() + " is out of stock");
            }
        }

        // Check customer balance after calculating total
        double totalAmount = calculateSubtotal(cart) + calculateShippingFee(cart);
        if (totalAmount > customer.getBalance()) {
            throw new IllegalStateException("Insufficient balance");
        }
    }

    private double calculateSubtotal(Cart cart) {
        return cart.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    private double calculateShippingFee(Cart cart) {
        double totalWeight = cart.getItems().stream()
                .filter(item -> item.getProduct().requiresShipping())
                .mapToDouble(item -> ((Shippable)item.getProduct()).getWeight() * item.getQuantity())
                .sum();

        return totalWeight * SHIPPING_FEE_PER_KG;
    }

    private void processPayment(Customer customer, double amount) {
        customer.paid(amount);
    }

    private void updateInventory(Cart cart) {
        for (ShoppingCart item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
    }

    private void handleShipping(Cart cart) {
        List<Shippable> shippableItems = cart.getItems().stream()
                .filter(item -> item.getProduct().requiresShipping())
                .map(item -> new ShippingItem(item))
                .collect(Collectors.toList());

        if (!shippableItems.isEmpty()) {
            shippingService.shipItems(shippableItems);
        }
    }

    private void printReceipt(Cart cart, double subtotal, double shippingFee,
                              double totalAmount, Customer customer) {
        System.out.println("** Checkout receipt **");
        for (ShoppingCart item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", totalAmount);
        System.out.printf("Remaining balance %.0f%n", customer.getBalance());
    }
}