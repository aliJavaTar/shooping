package ir.maktab.shoopping;

import ir.maktab.shoopping.entity.Customer;
import ir.maktab.shoopping.repository.service.CustomerManagerImplement;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ShoppingSystem {
    static Scanner input = new Scanner(System.in);

    public void startMenu() throws SQLException {
        System.out.println(" You Must Register in Shopping ");
        registerCustomer();
    }

    private void registerCustomer() throws SQLException {
        CustomerManagerImplement customerRegister = new CustomerManagerImplement();
        Customer customer = new Customer();
        //inputCustomer is method for input customer.......
        customer = inputCustomer(customer);
        //insertCustomer method in CustomerManagerImplement class for connect to dataBase
        customerRegister.insertCustomer(customer.getUsername(), customer.getPassword());
    }

    boolean check = true;

    private Customer inputCustomer(Customer customer) {
        boolean checkUserName = false;
        boolean checkPassword = false;
       //checkUserName && checkPassword for once input .........
        do {
            if (!checkUserName)
            {
                System.out.println("hi baby please Enter your username : ");
                String username = input.next();
                checkUserName = cheekUserName(username);
                if (checkUserName)
                    customer.setUsername(username);
                else System.out.println("username false");
            }
            if (!checkPassword)
            {
                System.out.println("enter your password ! \n " +
                        "[password must be use lowerCase and UpperCase and number and char like( # ^ &) ");
                String password = input.next();
                checkPassword = cheekPassword(password);
                if (checkPassword)
                    customer.setPassword(password);
                else System.out.println("password false");
            }
            if (checkPassword && checkUserName)
                check = false;
        } while (check);


        return customer;
    }

    private boolean cheekUserName(String text) {
        String regex = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){1,16}[a-zA-Z0-9]$";
        boolean isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

    private boolean cheekPassword(String text) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        boolean isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

}
