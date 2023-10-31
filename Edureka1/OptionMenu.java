package Edureka1;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    int selection;

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(9876543, 9876);
                data.put(9876542, 9875);
                System.out.println("Welcome to the ATM project!");
                System.out.println("Enter Your Customer Number:");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter Your Pin Number:");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(S). Only numbers." + "\n");
                x = 2;
            }
            boolean found = false;
            for(Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("\n" + "Wrong Customer number or Pin Number");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice:");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice.");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice:");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                double withdrawalAmount = menuInput.nextDouble();
                withdrawFromChecking(withdrawalAmount);
                getAccountType();
                break;

            case 3:
                double depositAmount = menuInput.nextDouble();
                depositToChecking(depositAmount);
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice.");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                double withdrawalAmount = menuInput.nextDouble();
                withdrawFromSaving(withdrawalAmount);
                getAccountType();
                break;

            case 3:
                double depositAmount = menuInput.nextDouble();
                depositToSaving(depositAmount);
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice.");
                getSaving();
        }
    }

    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}
