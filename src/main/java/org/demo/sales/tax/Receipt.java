package org.demo.sales.tax;

import java.util.List;

public class Receipt {
    private List<Product> products;
    private double totalTax;
    private double finalCost;

    public Receipt(List<Product> products) {
        this.products = products;
        calculateTotalsAndPrintProductDetails();
    }

    private void calculateTotalsAndPrintProductDetails() {
        totalTax = 0;
        finalCost = 0;

        for (Product p : products) {
            double tax = calculateTax(p);
            double finalPrice = p.getPrice() + tax;

            totalTax += tax;
            finalCost += finalPrice;

            System.out.printf("%d %s: %.2f%n", p.getQuantity(), p.getItemName(), finalPrice);
        }
    }

    public void printReceipt() {
        System.out.printf("Sales Taxes: %.2f%n", totalTax);
        System.out.printf("Total: %.2f%n", finalCost);
    }

    public double calculateTax(Product product) {
        double tax = 0;

        if (!product.getTaxableItemType().isExempt()) {
            tax += product.getPrice() * 0.10;
        }

        if (product.isImported()) {
            tax += product.getPrice() * 0.05;
        }

        return Math.ceil(tax * 20) / 20.0;
    }
}
