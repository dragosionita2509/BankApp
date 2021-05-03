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
import BrainBank.ServiceSystem.Services;
import BrainBank.ServiceSystem.Transaction;
import com.sun.security.ntlm.Client;

import java.io.Reader;
import java.io.Writer;
import java.util.*;

class SortByName implements Comparator<Bank> {

    public int compare(Bank a, Bank b) {
        return a.getTitle().compareTo(b.getTitle());
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<UnregisteredClient> clientList = new ArrayList<UnregisteredClient>();
        ArrayList<Bank> bankList = new ArrayList<Bank>();

        ReaderClass.getInstance().bankReader(bankList);
        ReaderClass.getInstance().clientReader(clientList);
        ReaderClass.getInstance().cardReader(clientList);
        ReaderClass.getInstance().accountReader(clientList);

        Services.makeTransaction((CurrentAccount)(((IndividualClient)clientList.get(0)).getCardList().get(0).getAccount()),
                ((CurrentAccount)(((IndividualClient)clientList.get(1)).getCardList().get(0).getAccount())),
                300,"25 APR 2019");

        System.out.println(Services.currencyExchange(100,"EUR","RON"));
        System.out.println(Services.makeLoan("25 AUG 2009",60,1800f));



        WriterClass.getInstance().bankWriter(bankList);
        WriterClass.getInstance().clientWriter(clientList);
        WriterClass.getInstance().cardWriter(clientList);
        WriterClass.getInstance().accountWriter(clientList);


    }
}
