package BrainBank.DatabaseSystem;

import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;

import java.sql.*;
import java.util.ArrayList;

public class ReadFunctions {


    public void readBank(ArrayList<Bank> bankList) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            Statement statement = con.createStatement();
            ResultSet bankRes = statement.executeQuery("SELECT * FROM bank");
            while (bankRes.next()) {
                Bank newBank = new Bank(bankRes.getString("title"), bankRes.getString("address"));
                bankList.add(newBank);
            }

        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readClient(ArrayList<IndividualClient> clientList)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            Statement statement = con.createStatement();
            ResultSet clientRes = statement.executeQuery("SELECT * FROM client");
            while (clientRes.next()) {
                IndividualClient newClient = new IndividualClient();
                newClient.setCNP(clientRes.getString("CNP"));
                newClient.setFirst_name(clientRes.getString("first_name"));
                newClient.setLast_name(clientRes.getString("last_name"));
                newClient.setAge(clientRes.getInt("age"));
                clientList.add(newClient);
            }

        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readCard(ArrayList<IndividualClient> clientList)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            Statement statement = con.createStatement();
            ResultSet cardRes = statement.executeQuery("SELECT * FROM card");
            while (cardRes.next()) {
                Card newCard = new Card();
                newCard.setCardNumber(cardRes.getString("card_number"));
                newCard.setCVC(cardRes.getInt("CVC"));
                newCard.setPin(cardRes.getInt("pin"));
                newCard.setExpirationDate(cardRes.getString("expiration_date"));
                String searchForClient = cardRes.getString("CNP");
                for(IndividualClient client : clientList)
                {
                    if(client.getCNP().equals(searchForClient))
                        client.addCard(newCard);
                }

            }

        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readCurrentAccount(ArrayList<IndividualClient> clientList)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            Statement statement = con.createStatement();
            ResultSet accountRes = statement.executeQuery("SELECT * FROM current_account");
            while (accountRes.next()) {
                CurrentAccount newAcc = new CurrentAccount();
                newAcc.setBalance(accountRes.getFloat("balance"));
                newAcc.setIBAN(accountRes.getString("IBAN"));
                newAcc.setOpeningDate(accountRes.getString("opening_date"));
                newAcc.setCurrency(accountRes.getString("currency"));
                String searchForCard = accountRes.getString("card_number");
                for(IndividualClient client : clientList)
                {
                    for(Card card : client.getCardList())
                        if(card.getCardNumber().equals(searchForCard))
                            card.setAccount(newAcc);
                }
            }

        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readSavingsAccount(ArrayList<IndividualClient> clientList)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            Statement statement = con.createStatement();
            ResultSet accountRes = statement.executeQuery("SELECT * FROM savings_account");
            while (accountRes.next()) {
                SavingsAccount newAcc = new SavingsAccount();
                newAcc.setBalance(accountRes.getFloat("balance"));
                newAcc.setIBAN(accountRes.getString("IBAN"));
                newAcc.setOpeningDate(accountRes.getString("opening_date"));
                newAcc.setCurrency(accountRes.getString("currency"));
                newAcc.setInterestRate(accountRes.getFloat("interest_rate"));
                newAcc.setWithdrawLimit(accountRes.getInt("withdraw_limit"));
                String searchForCard = accountRes.getString("card_number");

                for(IndividualClient client : clientList)
                {
                    for(Card card : client.getCardList())
                        if(card.getCardNumber().equals(searchForCard))
                            card.setAccount(newAcc);
                }
            }

        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
