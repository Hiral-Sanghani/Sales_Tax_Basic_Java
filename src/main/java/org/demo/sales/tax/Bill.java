package org.demo.sales.tax;


import java.util.Arrays;
import java.util.List;

public class Bill {
    public static void main(String[] args) {
        List<Product> productsList1 = Arrays.asList(
                new Product("book", 1, 12.49, ItemTaxEnum.BOOK, false),
                new Product("music CD", 1, 14.99, ItemTaxEnum.OTHERGOOD, false),
                new Product("chocolate bar", 1, 0.85, ItemTaxEnum.FOOD, false));

        List<Product> productsList2 = Arrays.asList(
                new Product("imported box of chocolates", 1, 10.0, ItemTaxEnum.FOOD, true),
                new Product("imported bottle of perfume", 1, 47.50, ItemTaxEnum.OTHERGOOD, true));

        List<Product> productsList3 = Arrays.asList(
                new Product("imported bottle of perfume", 1, 27.99, ItemTaxEnum.OTHERGOOD, true),
                new Product("bottle of perfume", 1, 18.99, ItemTaxEnum.OTHERGOOD, false),
                new Product("packet of headache pills", 1, 9.75, ItemTaxEnum.MEDICAL, false),
                new Product("imported box of chocolates", 1, 11.25, ItemTaxEnum.FOOD, true));


        new Receipt(productsList1).printReceipt();
        System.out.println("\n  \n");
        new Receipt(productsList2).printReceipt();
        System.out.println("\n  \n");
        new Receipt(productsList3).printReceipt();

    }
}