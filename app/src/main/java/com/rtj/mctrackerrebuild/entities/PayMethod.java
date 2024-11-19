package com.rtj.mctrackerrebuild.entities;

public enum PayMethod {
    CASH("Cash", 125),
    UnitedHealth("United Health Insurance", 30),
    FirstGroup("First Group Health", 35)
    ;
    private String displayName;
    private int amountDue;

    PayMethod(String cash, int i) {
        this.displayName = displayName;
        this.amountDue = amountDue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAmountDue() {
        return amountDue;
    }
    @Override
    public String toString() {
        return displayName + "Amount Due $" + amountDue;
    }
}
