package BrainBank.DatabaseSystem;

import BrainBank.CardSystem.Card;
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

}
