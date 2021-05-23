package BrainBank.AccountType;

public class SavingsAccount implements Account {

    private static int savingsCount;
    private String IBAN;
    private float balance;
    private int withdrawLimit;
    private String openingDate;
    private float interestRate;
    private String currency;


    public SavingsAccount(String IBAN, float balance, String openingDate, float interestRate, int withdrawLimit, String currency) {
        savingsCount++;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.IBAN = IBAN;
        this.openingDate = openingDate;
        this.interestRate = interestRate;
        this.currency = currency;
    }

    public SavingsAccount() {

    }

    public static int getSavingsCount() {
        return savingsCount;
    }

    public static void setSavingsCount(int savingsCount) {
        SavingsAccount.savingsCount = savingsCount;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public String getIBAN() {
        return IBAN;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                ", withdrawLimit=" + withdrawLimit +
                ", IBAN='" + IBAN + '\'' +
                ", openingDate='" + openingDate + '\'' +
                ", interestRate=" + interestRate +
                ", currency='" + currency + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Float.compare(that.balance, balance) == 0 && withdrawLimit == that.withdrawLimit && Float.compare(that.interestRate, interestRate) == 0 && IBAN.equals(that.IBAN) && openingDate.equals(that.openingDate) && currency.equals(that.currency);

    }


    public void deposit(float amount) {
        balance += amount;
    }

    @Override
    public AccountStatement Statement() {
        if (this == null) return null;
        else {
            {
                AccountStatement AS = new AccountStatement(balance, openingDate, IBAN);
                return AS;
            }
        }

    }

    @Override
    public void makeTransaction(CurrentAccount c, float f, String s) {
        System.out.println("This is only allowed in CurrentAccount class");
    }


}
