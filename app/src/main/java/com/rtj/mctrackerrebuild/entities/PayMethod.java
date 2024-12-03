package com.rtj.mctrackerrebuild.entities;

public enum PayMethod {
    CASH(0,"Cash", "125"),
    UnitedHealth(1,"United Health Insurance", "30"),
    FirstGroup(2,"First Group Health", "35"),
    CreditCard(3,"Credit Card","130");
    private int id;
    private String displayName;
    private String amountDue;

    PayMethod(int id,String displayName, String amountDue ) {
        this.id = id;
        this.displayName = displayName;
        this.amountDue = amountDue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return displayName + "Amount Due $" + amountDue;
    }
}
