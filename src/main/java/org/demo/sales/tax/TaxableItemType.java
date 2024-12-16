package org.demo.sales.tax;

public enum TaxableItemType {
    BOOK(true),
    MEDICAL(true),
    FOOD(true),
    OTHERGOOD(false);

    private final boolean isExempt;

    TaxableItemType(boolean isExempt) {
        this.isExempt = isExempt;
    }

    public boolean isExempt() {
        return isExempt;
    }
}
