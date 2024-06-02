package Model;

import java.util.List;

public class Order {
    private List<Menu> items;
    private double totalPrice;
    private String paymentMethod;
    private int orderNumber;

    public Order(List<Menu> items, double totalPrice, String paymentMethod, int orderNumber) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderNumber = orderNumber;
    }

    public List<Menu> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
