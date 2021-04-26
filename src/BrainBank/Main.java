package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.CurrencyExchange;
import BrainBank.ServiceSystem.Loan;
import com.sun.security.ntlm.Client;

import java.util.*;

class SortByName implements Comparator<Bank> {

    public int compare(Bank a, Bank b) {
        return a.getTitle().compareTo(b.getTitle());
    }

}

public class Main {

    public static void main(String[] args) {

        ArrayList<UnregisteredClient> ClientList = new ArrayList<UnregisteredClient>();

        Exceptions exc = new Exceptions(); //Exceptions este o clasa care contine conditiile de existenta pentru toate celelalte clase, aceasta va fi apelata in clase individual dar pentru exemplificare o voi scrie in main
        ArrayList <Account> AccList = new ArrayList<Account>();
        Account Curr1 = new CurrentAccount("RO90BACX0000001731067002",502906, "25 FEB 2004", "EUR");
        if (!exc.checkCurrAccount((CurrentAccount) Curr1)) Curr1 = null;
        Account Savings1 = new SavingsAccount("RO73RZBR0000001966332123",9004,1,"9 JAN 2005", 0.3f, "USD");
        if(!exc.checkSavingsAccount((SavingsAccount) Savings1)) Savings1 = null;
        Account Curr2 = new CurrentAccount("RO90BACX00550011231767052",50199922, "25 FEB 2008", "RON");
        Account Savings2 = new SavingsAccount("RO45RZBR0000531921335683",4250,1,"9 JAN 2005", 0.2f, "EUR");
        Account Curr3 = new CurrentAccount("RO43BACX00154012231763372",6020, "25 MAR 2014", "RON");
        Account Savings3 = new SavingsAccount("RO65RZBR0000531921330225",69420,1,"18 DEC 2014", 0.6f, "RON");



        Card card1 = new Card("4462559698116632", "25 APR 2021",402,9952,Curr1);
        Card card2 = new Card("8261259699506632", "22 MAR 2017",162,1252,Curr2);
        Card card3 = new Card("5212255559506731", "22 JAN 2016",615,9912,Savings1);
        Card card4 = new Card("5272111557846236", "22 SEP 2018",335,4413,Savings2);
        Card card5 = new Card("9986112355981106", "5 NOV 2021", 449,1234,Curr3);
        Card card6 = new Card("1199411299412211", "5 AUG 2021", 194,1855, Savings3);



        UnregisteredClient Cl1 = new IndividualClient("5000824355012","Petrache","Andrei-Marius",24);
        UnregisteredClient Cl2 = new IndividualClient("5000826302555","Tiriac","Ion",70);
        UnregisteredClient Cl3 = new IndividualClient("6000216442565","Mocanu","Andreea",38);
        UnregisteredClient Cl4 = new IndividualClient("6000221166214","Opris","Marioara",56);
        UnregisteredClient Cl5 = new UnregisteredClient("5000926112675");



        ((IndividualClient)Cl1).addCard(card1);
        ((IndividualClient)Cl1).addCard(card3);
        ((IndividualClient)Cl2).addCard(card2);
        ((IndividualClient)Cl2).addCard(card4);
        ((IndividualClient)Cl3).addCard(card5);
        ((IndividualClient)Cl4).addCard(card6);

        ClientList.add(Cl1);
        ClientList.add(Cl2);
        ClientList.add(Cl3);
        ClientList.add(Cl4);
        int x = 1;
        Iterator<UnregisteredClient> it = ClientList.iterator();
        while(it.hasNext())
        {
            System.out.println("Clientul " + x+ "\n");
            ++x;
            System.out.println(it.next() + "\n\n");
        }

        System.out.println("\n-----------------------------------------------------------------------------\n\n");

        Bank b1 = new Bank("Banca Bogatilor", "Strada Banilor fara numar");
        Bank b2 = new Bank("Banca Saracilor", "Strada Saraciei 100");
        Bank b3 = new Bank("Banca Intelectualilor", "Strada Intelectului 1");
        Bank b4 = new Bank("Banca Geniilor", "Strada Dragos 5");

        ArrayList<Bank> BankList = new ArrayList<Bank>();

        BankList.add(b1);
        BankList.add(b2);
        BankList.add(b3);
        BankList.add(b4);

        Collections.sort(BankList,new SortByName());

       Iterator<Bank> It= BankList.iterator();
        x=1;
       while(It.hasNext()) {
           System.out.println("Banca " +x +"  " + It.next());
           ++x;
       }

        System.out.println("\n-----------------------------------------------------------------------------\n\n");


        Loan l1 = new Loan("5 DEC 2020", 12, 1500);
        Loan l2 = new Loan("6 APR 2019",6,2500);
        Pair p1 = new Pair((IndividualClient) Cl1,l1);
        Pair p2 = new Pair((IndividualClient) Cl2,l2);

        Set <Pair> Loans = new HashSet<Pair>();

        Loans.add(p1);
        Loans.add(p2);

        Iterator<Pair> i = Loans.iterator();

        while(i.hasNext()) {
            System.out.println("\n" + i.next() + "\n");
        }

        System.out.println("\n-----------------------------------------------------------------------------\n\n");

        ArrayList<CurrencyExchange> CE = new ArrayList<CurrencyExchange>();

        CurrencyExchange ce1 = new CurrencyExchange();

        System.out.println(ce1.EUR_RON(100));
        System.out.println(ce1.USD_RON(100));


    }



}
