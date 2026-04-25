package com.airtribe.smartparking.model;

public enum TransactionStatus {
    ACTIVE(1, "Active"),
    COMPLETED(2, "Completed"),
    CANCELLED(3, "Cancelled"),
    DISPUTED(4, "Disputed");

    private final int code;
    private final String description;

    TransactionStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }

}
