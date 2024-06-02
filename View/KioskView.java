package View;

import Model.Menu;
import Model.Order;

import java.util.List;
import java.util.Scanner;

public class KioskView {
    private Scanner scanner;

    public KioskView() {
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("버거 키오스크 입니다 !");
        System.out.println("1. Burgers");
        System.out.println("2. Sides");
        System.out.println("3. Drinks");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.print("Please select an option: ");
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public void displayItems(List<Menu> items) {
        for (int i = 0; i < items.size(); i++) {
            Menu item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice());
        }
        System.out.println("0. Return to main menu");
    }

    public int getItemChoice() {
        System.out.print("Please select an item or return to the main menu (0): ");
        return scanner.nextInt();
    }

    public boolean getBurgerType() {
        System.out.print("Would you like it as a set? (true/false): ");
        return scanner.nextBoolean();
    }

    public String getSize() {
        System.out.print("Choose size (Regular/Large): ");
        return scanner.next();
    }

    public void displayCart(List<Menu> items) {
        System.out.print("Your cart: ");
        for (Menu item : items) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total price: " + items.stream().mapToDouble(Menu::getPrice).sum());
        System.out.println("0. Return to main menu");
    }

    public void displayCheckout() {
        System.out.println("1. Pay with card");
        System.out.println("2. Pay with coupon");
        System.out.print("Please select a payment method: ");
    }

    public void displayReceipt(Order order) {
        System.out.println("========Receipt========");
        System.out.println("주문번호: " + order.getOrderNumber());
        System.out.println("Items: ");
        for (Menu item : order.getItems()) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println("Payment Method: " + order.getPaymentMethod());
        System.out.println("=======================");
    }

    public String getAdminPassword() {
        System.out.print("Enter admin password: ");
        return scanner.next();
    }
}
