import java.util.HashMap;  // Importing HashMap to store items.
import java.util.Scanner;  // Importing Scanner for user input.

// Class representing an item in the vending machine.
class Item {
    private String name;  // Name of the item (e.g., Soda, Chips).
    private int price;    // Price of the item in dollars.

    // Constructor for the Item class to initialize name and price.
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getter method to return the item's name.
    public String getName() {
        return name;
    }

    // Getter method to return the item's price.
    public int getPrice() {
        return price;
    }
}

// Class representing the vending machine.
class VendingMachine {
    private HashMap<Integer, Item> items;  // A collection of items with item number as key.
    private int balance;                   // User's current balance.

    // Constructor to initialize the vending machine with a balance and predefined items.
    public VendingMachine(int initialBalance) {
        this.balance = initialBalance;     // Set initial balance to the user's input.
        this.items = new HashMap<>();      // Initialize the HashMap to store items.
        // Adding items to the vending machine with item numbers 1, 2, 3.
        items.put(1, new Item("Soda", 25));      // Item 1: Soda costs $25.
        items.put(2, new Item("Chips", 15));     // Item 2: Chips cost $15.
        items.put(3, new Item("Chocolate", 20)); // Item 3: Chocolate costs $20.
    }

    // Method to display the available items.
    public void displayItems() {
        System.out.println("Available items:");
        // Loop through the items and print each item with its number and price.
        for (int key : items.keySet()) {
            Item item = items.get(key);  // Get the item associated with the current key.
            System.out.println(key + ". " + item.getName() + " – $" + item.getPrice());
        }
    }

    // Method to handle item purchasing.
    public boolean purchaseItem(int itemNumber) {
        // Check if the entered item number exists in the list of available items.
        if (items.containsKey(itemNumber)) {
            Item item = items.get(itemNumber);  // Get the item the user wants to buy.
            // Check if the user has enough balance to buy the item.
            if (balance >= item.getPrice()) {
                balance -= item.getPrice();  // Deduct the item price from the user's balance.
                System.out.println("Item purchased successfully. Your remaining balance is $" + balance);
                return true;  // Return true to indicate successful purchase.
            } else {
                System.out.println("You don't have enough balance to buy this item.");
                return false;  // Return false if the user doesn't have enough balance.
            }
        } else {
            // If the entered item number is invalid.
            System.out.println("Invalid item number. Please try again.");
            return false;  // Return false for invalid item selection.
        }
    }

    // Getter method to return the user's current balance.
    public int getBalance() {
        return balance;
    }

    // Method to check if the user has any remaining balance.
    public boolean hasBalance() {
        return balance > 0;  // Returns true if the balance is greater than 0.
    }
}

// Main class to simulate the vending machine.
public class Lariosa_VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input.
        int initialBalance = 0;  // Variable to store the initial balance.

        // Keep asking for the initial balance until it's valid (at least $15).
        while (initialBalance < 15) {
            System.out.print("Enter your initial balance: ");
            initialBalance = getValidIntInput(scanner);  // Get valid integer input from the user.

            // If the balance is less than 15, show an error message.
            if (initialBalance < 15) {
                System.out.println("Error: Initial balance must be at least $15. Please try again.");
            }
        }

        // Create a VendingMachine object with the initial balance.
        VendingMachine vendingMachine = new VendingMachine(initialBalance);
        boolean keepBuying = true;  // Variable to track if the user wants to keep buying items.

        // Continue buying items as long as the user has balance and wants to buy more.
        while (keepBuying && vendingMachine.hasBalance()) {
            vendingMachine.displayItems();  // Display the available items.

            // Ask the user to select the item they want to buy.
            System.out.print("Enter the item number you want to buy: ");
            int itemNumber = getValidIntInput(scanner);  // Get valid integer input for the item number.

            // Attempt to purchase the selected item.
            vendingMachine.purchaseItem(itemNumber);

            // If the user still has some balance, ask if they want to buy more items.
            if (vendingMachine.getBalance() > 0) {
                boolean validResponse = false;  // Variable to track if the input is valid.

                // Keep asking the user until they enter a valid response.
                while (!validResponse) {
                    System.out.print("Do you want to buy another item? (yes/no): ");
                    String answer = scanner.next().toLowerCase();  // Convert the answer to lowercase.

                    // Check if the answer is 'yes' or 'no'.
                    if (answer.equals("yes")) {
                        keepBuying = true;
                        validResponse = true;  // Valid input, exit loop.
                    } else if (answer.equals("no")) {
                        keepBuying = false;
                        validResponse = true;  // Valid input, exit loop.
                    } else {
                        // If the input is neither 'yes' nor 'no', print an error message.
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                }
            } else {
                // If the user runs out of balance, end the purchase.
                System.out.println("You have no remaining balance. Ending purchase.");
                keepBuying = false;  // Stop the purchase loop.
            }
        }

        // Print a thank you message at the end.
        System.out.println("Thank you for using the vending machine!");
        scanner.close();  // Close the Scanner to free up resources.

    }

    // Helper method to get valid integer input from the user.
    private static int getValidIntInput(Scanner scanner) {
        // Loop until the user enters a valid integer.
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");  // Error message for invalid input.
            scanner.next();  // Discard the invalid input.
        }
        return scanner.nextInt();  // Return the valid integer input.
    }
}
