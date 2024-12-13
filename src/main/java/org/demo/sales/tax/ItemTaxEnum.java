package org.demo.sales.tax;

public enum ItemTaxEnum {
    BOOK(true),
    MEDICAL(true),
    FOOD(true),
    OTHERGOOD(false);

    private final boolean isExempt;

    ItemTaxEnum(boolean isExempt) {
        this.isExempt = isExempt;
    }

    public boolean isExempt() {
        return isExempt;
    }
}
