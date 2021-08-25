package com.senla.model.entityes.enums;

public enum OrderStatus {
    CHECKIN("CHECKIN"), CHECKOUT("CHECKOUT");

    private String value;

    OrderStatus(String status) {
        this.value = status;
    }

    public String getValue() {
        return this.value;
    }
}
