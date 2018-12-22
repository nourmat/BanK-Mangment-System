package Entities;

import java.io.Serializable;

public class Account implements Serializable {
    private Client client;
    private int balance = 0;
    private boolean open = true;
    private boolean onLoan = false;
    private int loan;

    public Account (Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    @Override
    public String toString() {
        return "Client: " + client + "\n" + "Balance: " + balance
                + "\n" + "Open: " + open + "\n" + "On Loan: " + onLoan;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Account)) {
//            return false;
//        }
//        Account a = (Account) obj;
//        return a.ID == ID;
//    }
}
