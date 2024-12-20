package org.demo.sales.tax;

public class Product {
    private String itemName;
    private int quantity;
    private Double price;
    private TaxableItemType taxableItemType;
    private boolean isImported;

    public Product(String itemName, int quantity, Double price, TaxableItemType taxableItemType, boolean isImported) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.taxableItemType = taxableItemType;
        this.isImported = isImported;
    }

    public boolean isImported() {
        return isImported;
    }

    public TaxableItemType getTaxableItemType() {
        return taxableItemType;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
