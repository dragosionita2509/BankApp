package BrainBank.Files;

import BrainBank.AccountType.Account;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;
import BrainBank.ServiceSystem.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderClass {


    public static ReaderClass instance = null;

private ReaderClass() {

}

public static ReaderClass getInstance() {
    if(instance == null)
        instance = new ReaderClass();
    return instance;
}

public void readerBank(ArrayList<Bank> bankList) {

        BufferedReader fileReader = null;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader("src\\BrainBank\\Files\\Resources\\Banks.csv"));
            while((line = fileReader.readLine())!=null) {
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    Bank newBank = new Bank(tokens[0],tokens[1]);
                    bankList.add(newBank);
                }
            }
        }
        catch(Exception e) {
            System.out.println("Eroare la citirea din fisierul CSV(Bank)");
        }
        try {
            fileReader.close();
        } catch(IOException e) {
            System.out.println("Eroare la inchiderea fisierului CSV(Bank)");
        }

    }


public void readerClient(ArrayList<UnregisteredClient> clientList) {

    BufferedReader fileReader = null;
    try {
        String line = "";
        fileReader = new BufferedReader(new FileReader("src\\BrainBank\\Files\\Resources\\Clients.csv"));
        while ((line = fileReader.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length > 0) {
                UnregisteredClient newClient = null;
                if (tokens.length > 1) {
                    newClient = new IndividualClient(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                } else if (tokens.length <= 1) {
                    newClient = new UnregisteredClient(tokens[0]);
                }
                clientList.add(newClient);
            }
        }
    } catch (Exception e) {
        System.out.println("Eroare la citirea din fisierul csv(Client)");
    }
    try {
        fileReader.close();
    } catch (IOException e) {
        System.out.println("Eroare la inchiderea fisierului CSV(Client)");
    }
}
}
