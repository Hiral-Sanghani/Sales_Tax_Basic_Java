package org.demo.sales.tax;

public class ProductFactory {
    public static Product parseProductInput(String input) {
        try {
            String[] parts = input.split(" at ");
            if (parts.length != 2) return null;

            String[] quantityAndName = parts[0].split(" ", 2);
            int quantity = Integer.parseInt(quantityAndName[0].trim());
            String name = quantityAndName[1].trim();
            double price = Double.parseDouble(parts[1].trim());

            TaxableItemType category = fetchItemCategory(name);

            boolean isImported = name.toLowerCase().contains("imported");

            return new Product(name, quantity, price, category, isImported);
        } catch (Exception e) {
            return null;
        }
    }

    private static TaxableItemType fetchItemCategory(String name) {
        String lowerName = name.toLowerCase();

        if (lowerName.contains("book")) {
            return TaxableItemType.BOOK;
        } else if (lowerName.contains("chocolate") || lowerName.contains("food")) {
            return TaxableItemType.FOOD;
        } else if (lowerName.contains("pill") || lowerName.contains("medical")) {
            return TaxableItemType.MEDICAL;
        } else {
            return TaxableItemType.OTHERGOOD;
        }
    }
}
