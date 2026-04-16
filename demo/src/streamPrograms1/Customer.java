package streamPrograms1;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String city;
    private List<Order> orders;

    // Constructor
    public Customer(int id, String name, String city, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.orders = orders;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", orders=" + orders +
                '}';
    }
}