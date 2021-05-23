package BrainBank.DatabaseSystem;

import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.CardSystem.Card;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.Location.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteFunctions {



    public void deleteBank(Bank bank)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "DELETE FROM BANK WHERE title = " + "'" + bank.getTitle() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteCurrentAccount(CurrentAccount account)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "DELETE FROM CURRENT_ACCOUNT WHERE IBAN = " + "'" + account.getIBAN() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteSavingsAccount(SavingsAccount account)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "DELETE FROM SAVINGS_ACCOUNT WHERE IBAN = " + "'" + account.getIBAN() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteCard(Card card)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "DELETE FROM CARD WHERE CARD_NUMBER = " + "'" + card.getCardNumber() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteClient(IndividualClient client)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "DELETE FROM CLIENT WHERE CNP = " + "'" + client.getCNP() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    }
