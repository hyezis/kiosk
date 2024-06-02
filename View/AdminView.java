package View;

import Model.*;

import java.util.Scanner;
import java.util.List;

public class AdminView {
    private Scanner scanner;

    public AdminView() {
        scanner = new Scanner(System.in);
    }

    public void displayAdminMenu() {
        System.out.println("Admin Menu");
        System.out.println("1. View inventory");
        System.out.println("2. Add Menu");
        System.out.println("3. Edit Menu");
        System.out.println("4. Delete Menu");
        System.out.print("Please select an option: ");
    }

    public int getAdminChoice() {
        return scanner.nextInt();
    }

    public void displayInventory(List<Menu> items) {
        for (int i = 0; i < items.size(); i++) {
            Menu item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice());
        }
    }

    public Menu getItemDetails() {
        System.out.print("Enter item type (1: Burger, 2: Side, 3: Drink): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter stock: ");
        int stock = scanner.nextInt();

        if (type == 1) {
            return new Burger(name, price, stock, false); // 단품 버거
        } else if (type == 2) {
            return new Side(name, price, stock, "Regular");
        } else if (type == 3) {
            return new Drink(name, price, stock, "Regular");
        }

        return null;
    }

    public int getItemIndex() {
        System.out.print("Enter item index: ");
        return scanner.nextInt();
    }
}
