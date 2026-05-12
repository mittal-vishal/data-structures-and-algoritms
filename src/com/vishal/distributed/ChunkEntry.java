package com.vishal.distributed;

public class ChunkEntry {
    private String accountId;
    private double amount;
    public ChunkEntry(String accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }
}
