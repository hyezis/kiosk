package Model;

public abstract class Menu {
    private String name;
    private double price;
    private int stock;

    public Menu(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public abstract String getType();
}
