package BrainBank.Files;

import BrainBank.AccountType.Account;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.Transaction;

import java.io.BufferedReader;

public class ReaderClass {

public static String path = System.getProperty("user.dir") + "\\src\\BrainBank\\Files\\Resources";
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



}
