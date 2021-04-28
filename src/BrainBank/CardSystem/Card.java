package BrainBank.CardSystem;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;

public class Card {

    private static int cardCount=0;
    private String cardNumber;
    private String expirationDate;
    private int CVC;
    private int pin;
    private Account account;

    public Card(String cardNumber, String expirationDate, int CVC, int pin, Account account) {
        cardCount++;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.CVC = CVC;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCVC() {
        return CVC;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", CVC=" + CVC +
                ", pin=" + pin +
                ", account=" + account +
                "}\n";
    }
}
