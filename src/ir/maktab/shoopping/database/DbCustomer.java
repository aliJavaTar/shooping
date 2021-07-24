package ir.maktab.shoopping.database;

import ir.maktab.shoopping.entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbCustomer {
    private String url = "jdbc:mysql://localhost:3306/shooping";
    private String username="root";
    private String password="ALI33";
    private Connection connection;
    private PreparedStatement statement;
    private static final String INSERT_CUSTOMER="insert into customers(customer_username,customer_password) values (?,?)";
    private   void openConnection() throws SQLException
    {
        connection= DriverManager.getConnection(url,username,password);
    }
    private   void closeConnection() throws SQLException
    {
        connection.close();
    }

    public boolean insertCustomer(Customer customer) throws SQLException
    {
        openConnection();
        statement=connection.prepareStatement(INSERT_CUSTOMER);
        statement.setString(1,customer.getUsername());
        statement.setString(2,customer.getPassword());
        if (statement.executeUpdate()>0)
        {
            System.out.println("done");
            closeConnection();
        return true;
        }
        else {
            System.out.println("filed");
            closeConnection();
            return false;
        }
    }

}
