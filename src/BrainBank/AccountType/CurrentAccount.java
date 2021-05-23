package BrainBank.AccountType;

import BrainBank.CardSystem.Card;
import BrainBank.ServiceSystem.Transaction;

import java.util.ArrayList;
import java.util.Objects;

public class CurrentAccount implements Account {
    private static int currentCount;
    private String IBAN;
    private float balance;
    private String openingDate;
    private String currency;
    private ArrayList<Transaction> transactions;

    public CurrentAccount(String IBAN, float balance, String openingDate, String currency) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.openingDate = openingDate;
        this.currency = currency;
        transactions = new ArrayList<Transaction>();
    }

    public CurrentAccount() {

    }

    public static int getCurrentCount() {
        return currentCount;
    }

    public static void setCurrentCount(int currentCount) {
        CurrentAccount.currentCount = currentCount;
    }

    public String getIBAN() {
        return IBAN;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void makeTransaction(CurrentAccount q, float amount, String date) {
        if(this.balance<amount) System.out.println("Fonduri insuficiente");
        else {
            this.balance-=amount;
            q.setBalance(q.getBalance()+amount);
            Transaction p = new Transaction(this.getIBAN(),q.getIBAN(),date,amount);
                transactions.add(p);
        }
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", openingDate='" + openingDate + '\'' +
                ", currency='" + currency + '\'' +
                ", transactions='" + transactions +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentAccount that = (CurrentAccount) o;
        return Float.compare(that.balance, balance) == 0 && IBAN.equals(that.IBAN) && openingDate.equals(that.openingDate) && currency.equals(that.currency);
    }


    public void deposit(float amount) {
        balance+=amount;
    }

    @Override
    public AccountStatement Statement() {
        if (this==null) return null;
        else  {
            AccountStatement AS = new AccountStatement(balance, openingDate, IBAN, transactions);
            return AS;
        }

    }




}
