package BrainBank.Files;

import BrainBank.AccountType.Account;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.Transaction;

import java.io.BufferedReader;

public class ReaderClass {

public String path = System.getProperty("user.dir") + "\\src\\BrainBank\\Files\\Resources";
public static BufferedReader accountReader;
public static BufferedReader cardReader;
public static BufferedReader clientReader;
public static BufferedReader bankReader;
public static BufferedReader transactionReader;

public static ReaderClass instance = null;

private ReaderClass() {

}

public static ReaderClass getInstance() {
    if(instance == null)
        instance = new ReaderClass();
    return instance;
}

public Bank bankReader() {
    Bank newBank;
    return newBank;
}

public Account accountReader() {
    Account newAccount;
    return newAccount;
}

public Card cardReader() {
    Card newCard;
    return newCard;
}

public UnregisteredClient clientReader() {
    UnregisteredClient newClient;
    return newClient;
}

public Transaction transactionReader() {
    Transaction newTransaction;
    return newTransaction;
}


}
