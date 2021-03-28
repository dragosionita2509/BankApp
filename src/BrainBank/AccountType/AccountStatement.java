package BrainBank.AccountType;

import BrainBank.ServiceSystem.Transaction;

import java.util.ArrayList;

public class AccountStatement {

    private float balance;
    private String openingDate;
    private String IBAN;
    private ArrayList<Transaction> transactions;

    public AccountStatement(float balance, String openingDate, String IBAN, ArrayList<Transaction> transactions) {
        this.balance = balance;
        this.openingDate = openingDate;
        this.IBAN = IBAN;
        this.transactions = transactions;
    }

    public AccountStatement(float balance, String openingDate, String IBAN) {
        this.balance = balance;
        this.openingDate = openingDate;
        this.IBAN = IBAN;
        transactions = null;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "balance=" + balance +
                ", openingDate='" + openingDate + '\'' +
                ", IBAN='" + IBAN + '\'' +
                '}';
    }

    public String toString2() {
        return "AccountStatement{" +
                "balance=" + balance +
                ", openingDate='" + openingDate + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
