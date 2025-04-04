package business;

import interfaces.Shippable;
import shopping.ShoppingCart;

import java.util.List;

public class ShippingService {
    public void shipItems(List<Shippable> shippableItems) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : shippableItems) {
            System.out.printf("%s %.0fg%n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
