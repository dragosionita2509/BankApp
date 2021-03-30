package BrainBank.ServiceSystem;

import BrainBank.AccountType.Account;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;

public class Deposit implements OfflineService {

    private String Date;
    private float depositAmount;
    private String IBAN;
    private String CNP;
    private Bank bank;

    public Deposit(String depositDate) {
        this.Date = depositDate;
    }

    public void deposit(float amount, UnregisteredClient q, Account Acc) {
        depositAmount = amount;
        CNP = q.getCNP();
        IBAN = Acc.getIBAN();
        Acc.deposit(amount);
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String depositDate) {
        this.Date = depositDate;
    }

    public float getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(float depositAmount) {
        this.depositAmount = depositAmount;
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
        return "Deposit{" +
                "depositDate='" + Date + '\'' +
                ", depositAmount=" + depositAmount +
                ", IBAN='" + IBAN + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }



}
