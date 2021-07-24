package ir.maktab.shoopping.database;

import ir.maktab.shoopping.entity.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class DbCustomer {
    private String url = "jdbc:mysql://localhost:3306/shooping";
    private String username = "root";
    private String password = "ALI33";
    private Connection connection;
    private PreparedStatement statement;
    private static final String INSERT_CUSTOMER = "insert into customers(customer_username,customer_password) values (?,?)";
    private static final String INSERT_CUSTOMER_MONEY = "insert into customers(customer_username,customer_password,wallet) values (?,?,?)";
    private static final String UPDATE_WALLET_CUSTOMER = "UPDATE customers SET wallet=? WHERE customer_id =?";

    private void openConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    private void closeConnection() throws SQLException {
        connection.close();
    }

    public boolean insertCustomer(Customer customer) throws SQLException {
        openConnection();
        statement = connection.prepareStatement(INSERT_CUSTOMER);
        statement.setString(1, customer.getUsername());
        statement.setString(2, customer.getPassword());
        if (statement.executeUpdate() > 0) {
            System.out.println("done");
            closeConnection();
            return true;
        } else {
            System.out.println("filed");
            closeConnection();
            return false;
        }
    }

    public boolean insertCustomerWhitMoney(Customer customer) throws SQLException {
        openConnection();
        statement = connection.prepareStatement(INSERT_CUSTOMER_MONEY);
        statement.setString(1, customer.getUsername());
        statement.setString(2, customer.getPassword());
        statement.setInt(3, customer.getWallet());
        if (statement.executeUpdate() > 0) {
            System.out.println("done");
            closeConnection();
            return true;
        } else {
            System.out.println("filed");
            closeConnection();
            return false;
        }
    }

    public boolean updateWalletCustomer(int id, int wallet) throws SQLException {
        openConnection();
        statement = connection.prepareStatement(UPDATE_WALLET_CUSTOMER);
        statement.setInt(1, id);
        statement.setInt(2, wallet);
        if (statement.executeUpdate() > 0) {
            System.out.println("Update done");
            closeConnection();
            return true;
        } else {
            System.out.println("Update filed");
            closeConnection();
            return false;
        }
    }

}
