package Entities;

import java.io.Serializable;

public class Transaction implements Serializable{
    String defaultUserName;
    String transferToUserName;
    int amount;
    int balanceAtThatTime;
    String type;
    boolean To = true;

    public Transaction(String defaultUserName, int amount, String type,int balanceAtThatTime) {
        this.defaultUserName = defaultUserName;
        this.amount = amount;
        this.type = type;
        this.balanceAtThatTime = balanceAtThatTime;
    }

    public Transaction(String defaultUserName, String transferToUserName, int amount, String type,boolean To,int balanceAtThatTime) {
        this.defaultUserName = defaultUserName;
        this.transferToUserName = transferToUserName;
        this.amount = amount;
        this.type = type;
        this.To = To;
        this.balanceAtThatTime = balanceAtThatTime;
    }

    public String getTransferToUserName() {
        return transferToUserName;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAtThatTime() {
        return balanceAtThatTime;
    }

    public String getType() {
        return type;
    }

    public boolean isTo() {
        return To;
    }
}
