package org.demo.sales.tax;
import java.lang.Override;

public class TaxCalculatorImpl implements TaxCalculator{

    @Override
    public double calculateTax(Product product) {
        double basicTaxRate = product.getTaxableItemType().isExempt() ? 0.0 : 0.1;
        double importTaxRate = product.isImported() ? 0.05 : 0.0;

        double tax = product.getPrice() * (basicTaxRate + importTaxRate);
        return Math.ceil(tax * 20.0) / 20.0;
    }
}
