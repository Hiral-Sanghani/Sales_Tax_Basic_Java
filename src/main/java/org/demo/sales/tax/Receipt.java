package org.demo.sales.tax;

import java.text.DecimalFormat;

public class Receipt {
    private final TaxCalculator taxCalculator;
    private final DecimalFormat df = new DecimalFormat("0.00");

    public Receipt(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void generateReceipt(Cart cart) {
        double totalSalesTax = 0.0;
        double totalCost = 0.0;

        System.out.println("\nReceipt:");

        for (Product product : cart.getProducts()) {
            double itemTax = taxCalculator.calculateTax(product);
            double finalPrice = product.getQuantity() * (product.getPrice() + itemTax);

            totalSalesTax += product.getQuantity() * itemTax;
            totalCost += finalPrice;

            System.out.printf("%d %s: %s%n", product.getQuantity(), product.getItemName(), df.format(finalPrice));
        }

        System.out.printf("Sales Taxes: %s%n", df.format(totalSalesTax));
        System.out.printf("Total: %s%n", df.format(totalCost));
    }
}
