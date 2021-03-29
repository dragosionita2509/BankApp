package BrainBank.ServiceSystem;

import BrainBank.AccountType.Account;
import BrainBank.ClientSystem.UnregisteredClient;

public class Deposit implements OfflineService {

    private String depositDate;
    private float depositAmount;
    private String IBAN;
    private String CNP;

    public Deposit(String depositDate) {
        this.depositDate = depositDate;
    }

    public void deposit(float amount, UnregisteredClient q, Account Acc) {
        depositAmount = amount;
        CNP = q.getCNP();
        IBAN = Acc.getIBAN();
        Acc.deposit(amount);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositDate='" + depositDate + '\'' +
                ", depositAmount=" + depositAmount +
                ", IBAN='" + IBAN + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}
