package ir.maktab.shoopping.entity;

public class Customer {
    private int customerId;
    private String username;
    private String password;
    private int wallet;

    public Customer(String username, String password, int wallet) {
        this.username = username;
        this.password = password;
        this.wallet = wallet;
    }

    public Customer() {
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return
                "customerId = " + customerId +
                " username = " + username + '\'' +
                " password = " + password + '\'' +
                " wallet = " + wallet ;
    }
}
