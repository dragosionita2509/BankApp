package BrainBank.DatabaseSystem;

import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.Location.Bank;

import java.sql.*;
import java.util.ArrayList;

public class InsertFunctions {

    public InsertFunctions() {

    }

    public void InsertBank(Bank bank)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            String insertTitle = bank.getTitle();
            String insertAddress = bank.getAddress();

            Statement statement = con.createStatement();

            String query = "INSERT INTO BANK VALUES('" + insertTitle + "', '" + insertAddress + "')";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
    }
    }

    public void InsertClient(IndividualClient client)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            String insertCNP = client.getCNP();
            String insertFirstName = client.getFirst_name();
            String insertLastName = client.getLast_name();
            int insertAge = client.getAge();

            Statement statement = con.createStatement();

            String query = "INSERT INTO CLIENT VALUES('" + insertCNP + "', '" + insertFirstName + "', '"+ insertLastName + "', " + insertAge + ")";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void InsertCard(Card card,IndividualClient client)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            String insertCardNumber = card.getCardNumber();
            String insertExpirationDate = card.getExpirationDate();
            int insertCVC = card.getCVC();
            int insertPIN = card.getPin();
            String insertCNP = client.getCNP();


            Statement statement = con.createStatement();

            String query = "INSERT INTO CARD VALUES('" + insertCardNumber + "', '" + insertCNP + "', '"+ insertExpirationDate + "', " + insertCVC + "," + insertPIN +")";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void InsertCurrentAccount(CurrentAccount account, Card card)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            String insertIBAN = account.getIBAN();
            String insertCardNumber = card.getCardNumber();
            float insertBalance = account.getBalance();
            String insertOpeningDate = account.getOpeningDate();
            String insertCurrency = account.getCurrency();

            Statement statement = con.createStatement();

            String query = "INSERT INTO CURRENT_ACCOUNT VALUES('" + insertIBAN + "', '" + insertCardNumber + "',"+ insertBalance + ", '" + insertOpeningDate + "','" + insertCurrency +"')";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void InsertSavingsAccount(SavingsAccount account, Card card)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");

            String insertIBAN = account.getIBAN();
            String insertCardNumber = card.getCardNumber();
            float insertBalance = account.getBalance();
            int insertWithdrawLimit = account.getWithdrawLimit();
            String insertOpeningDate = account.getOpeningDate();
            float insertInterestRate = account.getInterestRate();
            String insertCurrency = account.getCurrency();

            Statement statement = con.createStatement();

            String query = "INSERT INTO SAVINGS_ACCOUNT VALUES('" + insertIBAN + "', '" + insertCardNumber + "',"+ insertBalance + "," + insertWithdrawLimit+  ", '" + insertOpeningDate +"', "+ insertInterestRate  + ",'" + insertCurrency +"')";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


}
