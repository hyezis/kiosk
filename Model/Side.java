package Model;

public class Side extends Menu {
    private String size;

    public Side(String name, double price, int stock, String size) {
        super(name, price, stock);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Side";
    }
}
