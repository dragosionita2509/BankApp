package BrainBank.ServiceSystem;

import BrainBank.AccountType.CurrentAccount;

public class Transaction implements OnlineService{

    private String IBAN1;
    private String IBAN2;
    private String transactionDate;
    private float amount;

    public Transaction(String IBAN1, String IBAN2, String transactionDate, float amount) {
        this.IBAN1 = IBAN1;
        this.IBAN2 = IBAN2;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public String getIBAN1() {
        return IBAN1;
    }

    public void setIBAN1(String IBAN1) {
        this.IBAN1 = IBAN1;
    }

    public String getIBAN2() {
        return IBAN2;
    }

    public void setIBAN2(String IBAN2) {
        this.IBAN2 = IBAN2;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "IBAN1='" + IBAN1 + '\'' +
                ", IBAN2='" + IBAN2 + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
