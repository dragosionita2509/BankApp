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

public class UpdateFunctions {

    public void updateBankTitle(Bank bank, String title)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "UPDATE BANK SET TITLE = '" + title + "' WHERE ADDRESS = '" + bank.getAddress() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCardPIN(Card card, String newPIN)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "UPDATE CARD SET PIN = '" + newPIN + "' WHERE PIN = '" + card.getPin() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateCurrentAccountBalance(CurrentAccount account, float newBalance)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "UPDATE CURRENT_ACCOUNT SET BALANCE = '" + newBalance + "' WHERE IBAN = '" + account.getIBAN() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateSavingsAccountBalance(SavingsAccount account, float newBalance)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "UPDATE SAVINGS_ACCOUNT SET BALANCE = '" + newBalance + "' WHERE IBAN = '" + account.getIBAN() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateSavingsAccountinterestRate(SavingsAccount account, float newInterestRate)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "25092000d");
            Statement statement = con.createStatement();

            String query = "UPDATE SAVINGS_ACCOUNT SET INTEREST_RATE = '" + newInterestRate + "' WHERE IBAN = '" + account.getIBAN() + "'";
            statement.execute(query);
            statement.close();
        }
        catch(SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

}
