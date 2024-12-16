package org.demo.sales.tax;

import org.demo.sales.tax.Cart;

import java.util.Scanner;

public class Bill {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product details in the following format:");
        System.out.println("name, quantity, price, category (BOOK/MEDICAL/FOOD/OTHERGOOD), isImported (true/false)");
        System.out.println("Type 'done' when you are finished adding products.\n");

        while (true) {
            System.out.print("Enter product details: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                Product product = parseProductInput(input);
                cart.addProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input format. Please try again: " + e.getMessage());
            }
        }

        if (cart.getProducts().isEmpty()) {
            System.out.println("No products were added. Exiting program.");
        } else {
            Receipt receipt = new Receipt(cart);
            receipt.printReceipt();
        }

        scanner.close();
    }

    private static Product parseProductInput(String input) throws IllegalArgumentException {
        String[] parts = input.split(",");

        if (parts.length != 5) {
            throw new IllegalArgumentException("Input must have exactly 5 values separated by commas.");
        }

        String name = parts[0].trim();
        int quantity;
        double price;
        TaxableItemType category;
        boolean isImported;

        try {
            quantity = Integer.parseInt(parts[1].trim());
            price = Double.parseDouble(parts[2].trim());
            category = TaxableItemType.valueOf(parts[3].trim().toUpperCase());
            isImported = Boolean.parseBoolean(parts[4].trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid data format: " + e.getMessage());
        }
        return new Product(name, quantity, price, category, isImported);
    }
}
