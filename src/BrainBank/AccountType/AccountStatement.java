package BrainBank.AccountType;

import BrainBank.ServiceSystem.Transaction;

import java.util.ArrayList;

public class AccountStatement {

    private static int StatementCount = 0;
    private float balance;
    private String openingDate;
    private String IBAN;
    private ArrayList<Transaction> transactions;



    public AccountStatement(float balance, String openingDate, String IBAN, ArrayList<Transaction> transactions) {
        StatementCount++;
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

    public static int getStatementCount() {
        return StatementCount;
    }

    public static void setStatementCount(int statementCount) {
        StatementCount = statementCount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
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
