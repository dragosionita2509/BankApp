package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.DatabaseSystem.InsertFunctions;
import BrainBank.Files.ReaderClass;
import BrainBank.Files.WriterClass;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.CurrencyExchange;
import BrainBank.ServiceSystem.Loan;
import BrainBank.ServiceSystem.Services;
import BrainBank.ServiceSystem.Transaction;
import com.mysql.cj.x.protobuf.MysqlxCrud;
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


        InsertFunctions ins = new InsertFunctions();
        IndividualClient client1 = new IndividualClient("5000824355012","Petrache","Andrei-Marius",24);
        Account acc1 = new CurrentAccount("RO90BACX0000001731067002",500806.0f,"25 FEB 2004","RON");
        Account acc2 = new SavingsAccount("RO45RZBR0000531921335683",4250.0f,"9 JAN 2005",0.2f,1,"EUR");
        Card card1 = new Card("4491251699134462","29 APR 2023",215,9955,acc1);
        Card card2 = new Card("9986112355981106","5 NOV 2021",449,1234,acc2);

        ins.InsertSavingsAccount((SavingsAccount) acc2,card2);





    }
}
