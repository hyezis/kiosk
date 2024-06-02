package Controller;

import Model.*;
import View.AdminView;

import java.util.List;

public class AdminController {
    private AdminView view;
    private List<Menu> items;
    private Database database;

    public AdminController(AdminView view, List<Menu> items, Database database){
        this.view = view;
        this.items = items;
        this.database = database;
    }

    public void start() {
        while (true) {
            view.displayAdminMenu();
            int choice = view.getAdminChoice();
            switch (choice) {
                case 1:
                    view.displayInventory(items);
                    break;
                case 2:
                    handleAddItem();
                    break;
                case 3:
                    handleEditItem();
                    break;
                case 4:
                    handleRemoveItem();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleAddItem() {
        Menu newItem = view.getItemDetails();
        if (newItem != null) {
            if (newItem instanceof Burger) {
                database.addBurger(newItem.getName(), newItem.getPrice(), newItem.getStock());
            } else if (newItem instanceof Side) {
                database.addSide(newItem.getName(), newItem.getPrice(), newItem.getStock());
            } else if (newItem instanceof Drink) {
                database.addDrink(newItem.getName(), newItem.getPrice(), newItem.getStock());
            }
            items.add(newItem);
            System.out.println(newItem.getName() + " has been added.");
        }
    }


    private void handleEditItem() {
        view.displayInventory(items);
        int index = view.getItemIndex() - 1;
        if (index >= 0 && index < items.size()) {
            Menu oldItem = items.get(index);
            Menu newItem = view.getItemDetails();
            if (newItem != null) {
                if (newItem instanceof Burger) {
                    database.addBurger(newItem.getName(), newItem.getPrice(), newItem.getStock());
                } else if (newItem instanceof Side) {
                    database.addSide(newItem.getName(), newItem.getPrice(), newItem.getStock());
                } else if (newItem instanceof Drink) {
                    database.addDrink(newItem.getName(), newItem.getPrice(), newItem.getStock());
                }
                items.set(index, newItem);
                System.out.println(oldItem.getName() + " has been updated to " + newItem.getName());
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void handleRemoveItem() {
        view.displayInventory(items);
        int index = view.getItemIndex() - 1;
        if (index >= 0 && index < items.size()) {
            Menu removedItem = items.remove(index);
            System.out.println(removedItem.getName() + " has been removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }
}
