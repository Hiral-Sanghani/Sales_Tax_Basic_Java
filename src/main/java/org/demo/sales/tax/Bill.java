package org.demo.sales.tax;

import java.util.Scanner;

public class Bill {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter products in the format '1 book at 12.49'.");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            Product product = ProductFactory.parseProductInput(input);
            if (product != null) {
                cart.addProduct(product);
            } else {
                System.out.println("Invalid input format. Please try again: ");
            }
        }

        Receipt receiptGenerator = new Receipt(new TaxCalculatorImpl());
        receiptGenerator.generateReceipt(cart);
    }
}
