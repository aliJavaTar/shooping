package ir.maktab.shoopping.repository.base;

import java.sql.SQLException;

public interface CustomerManager {
    boolean insertCustomer(String username, String password) throws SQLException;

    boolean insertCustomerWhitMoney(String username, String password, int wallet) throws SQLException;

    boolean updateCustomer(int id, int wallet) throws SQLException;
}
