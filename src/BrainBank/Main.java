package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Exceptions exc = new Exceptions();
        ArrayList <Account> AccList = new ArrayList<Account>();
        Account Curr1 = new CurrentAccount("RO90BACX0000001731067002",502906, "25 FEB 2004", "EUR");
        if (!exc.checkCurrAccount((CurrentAccount) Curr1))

        System.out.println(AccList);

        Account Savings1 = new SavingsAccount("RO73RZBR0000001966332123",9004,1,"9 JAN 2005", 0.3f, "USD");
        Account Curr2 = new CurrentAccount("RO90BACX00550011231767052",5012, "25 FEB 2008", "RON");
        Account Savings2 = new SavingsAccount("RO45RZBR0000531921335683",4250,1,"9 JAN 2005", 0.2f, "EUR");

        Card card1 = new Card("4462559698116632", "25 APR 2021",402,9952,Curr1);



    }



}
