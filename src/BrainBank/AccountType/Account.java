package BrainBank.AccountType;

public interface Account {

    void deposit(float amount);

    AccountStatement Statement();

    abstract void makeTransaction(CurrentAccount c,float f,String s);

}
