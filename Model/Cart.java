package Model;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<Menu> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Menu item) {
        items.add(item);
    }

    public void removeItem(Menu item) {
        items.remove(item);
    }

    public List<Menu> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Menu::getPrice).sum();
    }
}
