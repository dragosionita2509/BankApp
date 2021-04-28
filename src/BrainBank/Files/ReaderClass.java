package BrainBank.Files;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
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

public void bankReader(ArrayList<Bank> bankList) {

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


public void clientReader(ArrayList<UnregisteredClient> clientList) {

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

public void cardReader(ArrayList<UnregisteredClient> clientList) {
    BufferedReader fileReader = null;
    try {
        String line = "";
        fileReader = new BufferedReader(new FileReader("src\\BrainBank\\Files\\Resources\\Cards.csv"));
        while ((line = fileReader.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length > 0) {
                String searchForClient = tokens[4];
                for(UnregisteredClient client : clientList) {
                    if(((IndividualClient)client).getCNP().equals(searchForClient))
                    {
                        Card newCard = new Card(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),null);
                        ((IndividualClient) client).addCard(newCard);
                        break;
                    }
                }
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

    public void accountReader(ArrayList<UnregisteredClient> clientList) {
        BufferedReader fileReader = null;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader("src\\BrainBank\\Files\\Resources\\Accounts.csv"));
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Account newAccount = null;
                    if(tokens.length==7) {
                        newAccount = new SavingsAccount(tokens[0], Float.parseFloat(tokens[1]), tokens[2], Float.parseFloat(tokens[3]), Integer.parseInt(tokens[4]), tokens[5]);
                    }
                        else {
                        newAccount = new CurrentAccount(tokens[0],Float.parseFloat(tokens[1]),tokens[2],tokens[3]);
                        }
                    for(UnregisteredClient client : clientList)
                    {
                        int found = 0;
                        for(Card card : ((IndividualClient)client).getCardList()) {
                            if(card.getCardNumber().equals(tokens[tokens.length-1])) {
                                card.setAccount(newAccount);
                                found = 1;
                                break;
                            }
                        }
                        if(found==1)
                            break;
                    }
                    }
                }
            }
        catch (Exception e) {
            System.out.println("Eroare la citirea din fisierul csv(Account)");
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Eroare la inchiderea fisierului CSV(Account)");
        }
    }
}

