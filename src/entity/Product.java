package entity;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount>quantity)
            throw new IllegalArgumentException("Quantity equal Zero !!");
        this.quantity -= amount;
    }
    public abstract boolean doesExpire();
    public abstract boolean requiresShipping();
}
