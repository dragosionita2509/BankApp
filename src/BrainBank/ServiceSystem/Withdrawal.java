package BrainBank.ServiceSystem;

import BrainBank.AccountType.Account;
import BrainBank.ClientSystem.IndividualClient;

public class Withdrawal implements OfflineService{

    private String Date;
    private float sum;
    private String IBAN;
    private String CNP;

    public Withdrawal(String date, float sum, IndividualClient c, Account q) {
        Date = date;
        this.sum = sum;
        IBAN = q.getIBAN();
        CNP = c.getCNP();
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
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
    public String toString() {
        return "Withdrawal{" +
                "Date='" + Date + '\'' +
                ", sum=" + sum +
                ", IBAN='" + IBAN + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
