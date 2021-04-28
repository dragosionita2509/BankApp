package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Files.ReaderClass;
import BrainBank.Files.WriterClass;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.CurrencyExchange;
import BrainBank.ServiceSystem.Loan;
import BrainBank.ServiceSystem.Transaction;
import com.sun.security.ntlm.Client;

import java.io.Reader;
import java.util.*;

class SortByName implements Comparator<Bank> {

    public int compare(Bank a, Bank b) {
        return a.getTitle().compareTo(b.getTitle());
    }

}

public class Main {

    public static void main(String[] args) {

        ArrayList<UnregisteredClient> clientList = new ArrayList<UnregisteredClient>();
        ArrayList<Bank> bankList = new ArrayList<Bank>();
        ReaderClass.getInstance().bankReader(bankList);
        ReaderClass.getInstance().clientReader(clientList);
        ReaderClass.getInstance().cardReader(clientList);
        ReaderClass.getInstance().accountReader(clientList);

        System.out.println(clientList);

    }
}
