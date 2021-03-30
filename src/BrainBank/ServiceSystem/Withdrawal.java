package BrainBank.ServiceSystem;

import BrainBank.AccountType.Account;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.Location.Bank;

public class Withdrawal implements OfflineService{

    private String Date;
    private float amount;
    private String IBAN;
    private String CNP;
    private Bank bank;

    public Withdrawal(String date, float amount, IndividualClient c, Account q) {
        Date = date;
        this.amount = amount;
        IBAN = q.getIBAN();
        CNP = c.getCNP();
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public float getamount() {
        return amount;
    }

    public void setamount(float amount) {
        this.amount = amount;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "Date='" + Date + '\'' +
                ", amount=" + amount +
                ", IBAN='" + IBAN + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
