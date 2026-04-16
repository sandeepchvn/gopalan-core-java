package streamPrograms1;

import java.util.List;

public class Order {

    private int id;
    private String category;
    private double amount;
    private List<Product> products;

    // Constructor
    public Order(int id, String category, double amount, List<Product> products) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.products = products;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", products=" + products +
                '}';
    }
}