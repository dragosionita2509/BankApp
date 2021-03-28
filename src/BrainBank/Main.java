package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;

public class Main {

    public static void main(String[] args) {
        Account p = new CurrentAccount("RO90BACX0000001731067002",502, "25 FEB 2004", "EUR");
        Account x = new SavingsAccount("RO73RZBR0000001966332123",180002,1,"9 JAN 2005", 0.3f, "USD");
        Account l = new CurrentAccount("RO90BACX00550011231367002",5025, "25 FEB 2008", "EUR");
        Card Visa = new Card("4132599511192235","3 MAR 2023", 295, 6969,p);
        CurrentAccount s = new CurrentAccount("RO90BACX0000001731067002",502, "25 FEB 2004", "EUR");
        IndividualClient Dragos = new IndividualClient("5000925394451","Ionita","Dragos-Adrian",25);
        Dragos.addCard(Visa);

        p.makeTransaction((CurrentAccount) l,200f,"5 DEC 2006");
        p.makeTransaction((CurrentAccount)l,300f,"6 APR 2009");
        p.makeTransaction((CurrentAccount)l,100f,"8 APR 2019");
        System.out.println(p);


    }



}
