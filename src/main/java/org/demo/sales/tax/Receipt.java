package org.demo.sales.tax;

import java.text.DecimalFormat;

public class Receipt {
    private final Cart cart;
    private double totalSalesTax = 0.0;
    private double totalCost = 0.0;

    public Receipt(Cart cart) {
        this.cart = cart;
    }

    public void printReceipt() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\nReceipt:");

        for (Product product : cart.getProducts()) {
            double itemTax = calculateTax(product);
            double finalPrice = product.getQuantity() * (product.getPrice() + itemTax);

            totalSalesTax += product.getQuantity() * itemTax;
            totalCost += finalPrice;

            System.out.printf("%d %s: %s%n", product.getQuantity(), product.getItemName(), df.format(finalPrice));
        }

        System.out.printf("Sales Taxes: %s%n", df.format(totalSalesTax));
        System.out.printf("Total: %s%n", df.format(totalCost));
    }

    private double calculateTax(Product product) {
        double basicTaxRate = product.getItemTaxEnum().isExempt() ? 0.0 : 0.1;
        double importTaxRate = product.isImported() ? 0.05 : 0.0;

        double totalTaxRate = basicTaxRate + importTaxRate;
        double tax = product.getPrice() * totalTaxRate;


        return Math.ceil(tax * 20.0) / 20.0;
    }
}
