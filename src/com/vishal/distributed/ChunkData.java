package com.vishal.distributed;

public class ChunkData {

    private String accountId;
    private double amount;
    private int index;

    public ChunkData(int index, String accountId, double amount) {
        this.index = index;
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public int getIndex() {
        return index;
    }
}
