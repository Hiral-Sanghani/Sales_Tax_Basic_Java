package org.demo.sales.tax;

public class Product {

    private String itemName;
    private int quantity;
    private Double price;
    private ItemTaxEnum itemTaxEnum;
    private boolean isImported;

    public Product(String itemName, int quantity, Double price, ItemTaxEnum itemTaxEnum, boolean isImported) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.itemTaxEnum = itemTaxEnum;
        this.isImported = isImported;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public ItemTaxEnum getItemTaxEnum() {
        return itemTaxEnum;
    }

    public void setItemTaxEnum(ItemTaxEnum itemTaxEnum) {
        this.itemTaxEnum = itemTaxEnum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
