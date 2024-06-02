package Model;

public class Burger extends Menu {
    private boolean isSet;

    public Burger(String name, double price, int stock, boolean isSet) {
        super(name, price, stock);
        this.isSet = isSet;
    }

    public boolean isSet() {
        return isSet;
    }

    @Override
    public String getType() {
        return "Burger";
    }
}
