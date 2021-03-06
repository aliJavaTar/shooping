package ir.maktab.shoopping.repository.service;

import ir.maktab.shoopping.database.DbCustomer;
import ir.maktab.shoopping.entity.Customer;
import ir.maktab.shoopping.repository.base.CustomerManager;

import java.sql.SQLException;

public class CustomerManagerImplement implements CustomerManager {
   DbCustomer databaseCustomer;
   public CustomerManagerImplement()
   {
       databaseCustomer=new DbCustomer();
   }
    @Override
    public boolean insertCustomer(String username, String password) throws SQLException {

        return databaseCustomer.insertCustomer(new Customer(username,password));
    }
    @Override
    public boolean insertCustomerWhitMoney(String username, String password,int wallet) throws SQLException {

        return databaseCustomer.insertCustomerWhitMoney(new Customer(username,password,wallet));
    }

    @Override
    public boolean updateCustomer(int id ,int wallet) throws SQLException {
        return databaseCustomer.updateWalletCustomer(id,wallet);
    }
}
