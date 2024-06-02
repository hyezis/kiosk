package Controller;

import Model.*;
import View.KioskView;
import View.PaymentView;

import java.util.List;

public class KioskController {
    private KioskView view;
    private Cart cart;
    private List<Menu> burgers;
    private List<Menu> sides;
    private List<Menu> drinks;
    private AdminController adminController;
    private static final String ADMIN_PASSWORD = "admin";
    private static int orderNumberCounter = 1;

    public KioskController(KioskView view, Cart cart, List<Menu> burgers, List<Menu> sides, List<Menu> drinks, AdminController adminController) {
        this.view = view;
        this.cart = cart;
        this.burgers = burgers;
        this.sides = sides;
        this.drinks = drinks;
        this.adminController = adminController;
    }

    public void start() {
        while (true) {
            view.displayMainMenu();
            int choice = view.getUserInput();
            switch (choice) {
                case 0:
                    handleAdminAccess();
                    break;
                case 1:
                    handleBurgerSelection();
                    break;
                case 2:
                    handleSideSelection();
                    break;
                case 3:
                    handleDrinkSelection();
                    break;
                case 4:
                    handleViewCart();
                    break;
                case 5:
                    handleCheckout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleAdminAccess() {
        String password = view.getAdminPassword();
        if (ADMIN_PASSWORD.equals(password)) {
            adminController.start();
        } else {
            System.out.println("Incorrect password. Access denied.");
        }
    }

    private void handleBurgerSelection() {
        while (true) {
            view.displayItems(burgers);
            int itemChoice = view.getItemChoice();
            if (itemChoice == 0) {
                break; // 메인 메뉴로 돌아가기
            }
            Burger selectedItem = (Burger) burgers.get(itemChoice - 1);
            boolean isSet = view.getBurgerType();
            Burger burgerToAdd = new Burger(selectedItem.getName(), selectedItem.getPrice(), selectedItem.getStock(), isSet);
            cart.addItem(burgerToAdd);
            System.out.println(selectedItem.getName() + (isSet ? " (Set)" : " (Single)") + " added to cart.");
        }
    }

    private void handleSideSelection() {
        while (true) {
            view.displayItems(sides);
            int itemChoice = view.getItemChoice();
            if (itemChoice == 0) {
                break; // 메인 메뉴로 돌아가기
            }
            Side selectedItem = (Side) sides.get(itemChoice - 1);
            String size = view.getSize();
            Side sideToAdd = new Side(selectedItem.getName(), selectedItem.getPrice(), selectedItem.getStock(), size);
            cart.addItem(sideToAdd);
            System.out.println(selectedItem.getName() + " (" + size + ") added to cart.");
        }
    }

    private void handleDrinkSelection() {
        while (true) {
            view.displayItems(drinks);
            int itemChoice = view.getItemChoice();
            if (itemChoice == 0) {
                break; // 메인 메뉴로 돌아가기
            }
            Drink selectedItem = (Drink) drinks.get(itemChoice - 1);
            String size = view.getSize();
            Drink drinkToAdd = new Drink(selectedItem.getName(), selectedItem.getPrice(), selectedItem.getStock(), size);
            cart.addItem(drinkToAdd);
            System.out.println(selectedItem.getName() + " (" + size + ") added to cart.");
        }
    }

    private void handleViewCart() {
        while (true) {
            view.displayCart(cart.getItems());
            int choice = view.getUserInput();
            if (choice == 0) {
                break; // 메인 메뉴로 돌아가기
            }
        }
    }

    private void handleCheckout() {
        PaymentView paymentView = new PaymentView();
        String paymentMethod = paymentView.getPaymentMethod();
        String payment = null;

        if (paymentMethod.equals("1")) {
            payment = paymentView.getCardDetails();
        } else {
            payment = paymentView.getCouponDetails();
        }

        if (payment != null) {
            int orderNumber = orderNumberCounter++;
            Order order = new Order(cart.getItems(), cart.getTotalPrice(), paymentMethod, orderNumber);
            view.displayReceipt(order);
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
