package View;

import Model.*;

import java.util.Scanner;

public class PaymentView {
    private Scanner scanner;

    public PaymentView() {
        scanner = new Scanner(System.in);
    }

    public String getPaymentMethod() {
        System.out.println("1. Card");
        System.out.println("2. Coupon");
        System.out.print("Please select a payment method: ");
        return scanner.next();
    }

    public String getCardDetails() {
        System.out.print("Enter card number: ");
        String cardNumber = scanner.next();
        System.out.print("Enter expiry date (MM/YY): ");
        String expiryDate = scanner.next();
        return String.valueOf(new Card(cardNumber, expiryDate));
    }

    public String getCouponDetails() {
        System.out.print("Enter coupon code: ");
        String couponCode = scanner.next();
        return String.valueOf(new Coupon(couponCode));
    }
}
