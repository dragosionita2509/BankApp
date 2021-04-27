package BrainBank.Files;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class WriterClass {


    public static WriterClass instance = null;

    private WriterClass() {

    }

    public static WriterClass getInstance() {
        if(instance == null)
            instance = new WriterClass();
        return instance;
    }

    public static void bankWriter(ArrayList<Bank> bankList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\BrainBank\\Files\\Resources\\Banks.csv");
            for (Bank bank : bankList) {
                fileWriter.append(String.valueOf(bank.getTitle()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(bank.getAddress()));
                fileWriter.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Eroare in CsvWriter(Banca)");
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        }
            catch(IOException e){
                System.out.println("Eroare la inchidere fisierului CSV(Banca)");
            }
    }

    public static void clientWriter(ArrayList<UnregisteredClient> clientList) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\BrainBank\\Files\\Resources\\Clients.csv");
            for(UnregisteredClient client : clientList)
            {
                if(client instanceof IndividualClient) {
                    fileWriter.append(String.valueOf(client.getCNP()));
                    fileWriter.append(",");
                    fileWriter.append(String.valueOf(((IndividualClient) client).getFirst_name()));
                    fileWriter.append(",");
                    fileWriter.append(String.valueOf(((IndividualClient) client).getLast_name()));
                    fileWriter.append(",");
                    fileWriter.append(String.valueOf(((IndividualClient) client).getAge()));
                    fileWriter.append("\n");
                }
                else {
                    fileWriter.append(String.valueOf(client.getCNP()));
                    fileWriter.append("\n");
                }
            }
        }
        catch(Exception e) {
            System.out.println("Eroare in CsvWriter(Client)");
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException e) {
            System.out.println("Eroare la inchiderea fisierului CSV(Client)");
        }
    }

    public static void cardWriter(ArrayList<UnregisteredClient> clientList) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\BrainBank\\Files\\Resources\\Cards.csv");
            for(UnregisteredClient client : clientList)
            {
                if(client instanceof IndividualClient) {
                    for(Card card : ((IndividualClient)client).getCardList())
                    {
                        fileWriter.append(String.valueOf(card.getCardNumber()));
                        fileWriter.append(",");
                        fileWriter.append(String.valueOf(card.getExpirationDate()));
                        fileWriter.append(",");
                        fileWriter.append(String.valueOf(card.getCVC()));
                        fileWriter.append(",");
                        fileWriter.append(String.valueOf(card.getPin()));
                        fileWriter.append(",");
                        fileWriter.append(String.valueOf(client.getCNP()));
                        fileWriter.append("\n");

                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Eroare in CsvWriter(Card)");
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException e) {
            System.out.println("Eroare la inchiderea fisierului CSV(Card)");
        }
    }

    public static void accountWriter(ArrayList<UnregisteredClient> clientList) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\BrainBank\\Files\\Resources\\Accounts.csv");
            for(UnregisteredClient client : clientList)
            {
                if(client instanceof IndividualClient) {
                    for(Card card : ((IndividualClient)client).getCardList())
                    {
                        Account account = card.getAccount();
                        if(account instanceof CurrentAccount) {
                            fileWriter.append(String.valueOf(((CurrentAccount) account).getIBAN()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((CurrentAccount) account).getBalance()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((CurrentAccount) account).getOpeningDate()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((CurrentAccount) account).getCurrency()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(card.getCardNumber()));
                            fileWriter.append("\n");
                        }
                        else
                        {
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getIBAN()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getBalance()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getOpeningDate()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getInterestRate()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getWithdrawLimit()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(((SavingsAccount) account).getCurrency()));
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(card.getCardNumber()));
                            fileWriter.append("\n");
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Eroare in CsvWriter(Account)");
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException e) {
            System.out.println("Eroare la inchiderea fisierului CSV(Account)");
        }
    }


}
