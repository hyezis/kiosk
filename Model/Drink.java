package Model;

public class Drink extends Menu {
    private String size;

    public Drink(String name, double price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Drink";
    }
}
