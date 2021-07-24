package ir.maktab.shoopping.repository.base;

import java.sql.SQLException;

public interface CustomerManager {
    boolean insertCustomer(String username , String password) throws SQLException;
}
