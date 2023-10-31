package Edureka1;
import java.text.DecimalFormat;

public class Account {
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    // Set the customer number
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    // Get the customer number
    public int getCustomerNumber() {
        return customerNumber;
    }

    // Set pin number
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    // Get pin number
    public int getPinNumber() {
        return pinNumber;
    }

    // Get checking account balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Get saving account balance
    public double getSavingBalance() {
        return savingBalance;
    }

    // Deposit to checking account
    public void depositToChecking(double amount) {
        checkingBalance += amount;
    }

    // Withdraw from checking account
    public void withdrawFromChecking(double amount) {
        if (checkingBalance >= amount) {
            checkingBalance -= amount;
        } else {
            System.out.println("Insufficient funds in the checking account.");
        }
    }

    // Deposit to saving account
    public void depositToSaving(double amount) {
        savingBalance += amount;
    }

    // Withdraw from saving account
    public void withdrawFromSaving(double amount) {
        if (savingBalance >= amount) {
            savingBalance -= amount;
        } else {
            System.out.println("Insufficient funds in the saving account.");
        }
    }
}
