package ir.maktab.shoopping;

import ir.maktab.shoopping.entity.Customer;
import ir.maktab.shoopping.repository.service.CustomerManagerImplement;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ShoppingSystem {
    static Scanner input = new Scanner(System.in);

    public void startMenu() {
        System.out.println(" You Must Register in Shopping ");
        try {
            registerCustomer();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void registerCustomer()  {
        CustomerManagerImplement customerRegister = new CustomerManagerImplement();
        Customer customer = new Customer();
        //inputCustomer is method for input customer.......
        //insertCustomer method in CustomerManagerImplement class for connect to dataBase

        customer = inputCustomer(customer);
        System.out.println("do you want charge your wallet ? (enter yes or no)");
        try {
            String chargeWallet = input.next();
            if (chargeWallet.equals("yes"))
                registerWhitMoney(customerRegister, customer);
            else if (chargeWallet.equals("no")) {
                customerRegister.insertCustomer(customer.getUsername(), customer.getPassword());
            }else System.out.println("Value Entered false");
        } catch (Exception e) {
            System.out.println("Value Entered false");
        }
    }

    private void registerWhitMoney(CustomerManagerImplement customerRegister, Customer customer) {

        System.out.println("How mach money do you want enter :(مشتی هستی به مولا) ");
        try {
            int wallet = input.nextInt();
            customer.setWallet(wallet);
            customerRegister.insertCustomerWhitMoney(customer.getUsername(), customer.getPassword(), customer.getWallet());
        } catch (Exception exception) {
            System.out.println("Value Entered false ");
        }
    }

    boolean check = true;

    private Customer inputCustomer(Customer customer) {
        boolean checkUserName = false;
        boolean checkPassword = false;
        //checkUserName && checkPassword for once input .........
        do {
            if (!checkUserName) {
                System.out.println("hi baby please Enter your username : ");
                String username = input.next();
                checkUserName = cheekUserName(username);
                if (checkUserName)
                    customer.setUsername(username);
                else System.out.println("username false");
            }
            if (!checkPassword) {
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
        boolean isTrue;
        String regex = "^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){1,16}[a-zA-Z0-9]$";
        isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

    private boolean cheekPassword(String text) {
        boolean isTrue;
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        isTrue = Pattern.matches(regex, text);
        return isTrue;
    }

}
