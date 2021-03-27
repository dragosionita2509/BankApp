package BrainBank.AccountType;

import BrainBank.CardSystem.Card;

import java.util.ArrayList;

public class CurrentAccount implements Account {
    private static int accountNumber;
    private final String IBAN;
    private float balance;
    private float withdrawLimit;
    private ArrayList <Card> cards;
    private String openingDate;
    private String expirationDate;
    private String currency;

    public CurrentAccount(String IBAN, float balance, float withdrawLimit, ArrayList<Card> cards, String openingDate, String expirationDate, String currency) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.cards = cards;
        this.openingDate = openingDate;
        this.expirationDate = expirationDate;
        this.currency = currency;
    }

    public static int getAccountNumber() {
        return accountNumber;
    }

    public static void setAccountNumber(int accountNumber) {
        CurrentAccount.accountNumber = accountNumber;
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

    public float getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(float withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
