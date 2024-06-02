package View;

import Model.Menu;

import java.util.List;

public class CartView {
    public void displayCartItems(List<Menu> items) {
        System.out.println("Cart items: ");
        for (Menu item : items) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
    }

    public void displayCartOptions() {
        System.out.println("1. Remove item");
        System.out.println("2. Change quantity");
        System.out.println("3. Checkout");
        System.out.println("4. Continue browsing");
        System.out.println("Please select an option: ");
    }
}
