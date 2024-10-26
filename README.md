
# Vending Machine Program

Welcome to the **Vending Machine Program**. This is a Java-based simulation of a vending machine that allows users to input an initial balance, choose items to purchase, and handles transactions and balance updates.

## Objective

The objective of this project is to simulate a vending machine experience in a console application, enabling users to:
- Input an initial balance
- View a list of available items
- Select items to purchase based on their balance
- Automatically update the balance and inventory after each transaction

## Features

- Displays available items with prices.
- Allows users to input an initial balance (minimum of $15 required).
- Deducts item costs from the user's balance upon purchase.
- Handles cases of insufficient balance or invalid item selections.
- Continues purchases until the user has insufficient balance or opts to stop.

## How it Works

1. **Set Initial Balance**: The user is prompted to enter an initial balance, with a minimum of $15 required to proceed.
2. **Display Items**: The vending machine displays available items with their prices.
3. **Select Item**: The user selects an item to purchase by entering its item number.
4. **Transaction Processing**:
   - If the user has sufficient balance, the item is "dispensed," the balance is updated, and the remaining balance is displayed.
   - If the balance is insufficient, the program displays a message and prompts the user to select a different item.
5. **Repeat Purchases**: The program will continue to prompt the user for additional purchases until they either have insufficient balance or choose to stop.

### Sample Output

```bash
Enter your initial balance: 20

Available items:
1. Soda – $25
2. Chips – $15
3. Chocolate – $20

Enter the item number you want to buy: 2
Item purchased successfully. Your remaining balance is $5.

Do you want to buy another item? (yes/no): no
Thank you for using the vending machine!
```

## Code Walkthrough

### Classes and Key Methods

#### `Item` Class
Represents an item in the vending machine, containing:
- `name`: Name of the item (e.g., Soda, Chips).
- `price`: Price of the item in dollars.

```java
class Item {
    private String name;
    private int price;
    // Constructor and getters
}
```

#### `VendingMachine` Class
Manages the inventory of items and the user’s balance, containing:
- `displayItems()`: Displays available items and prices.
- `purchaseItem(int itemNumber)`: Checks if the item is available and if the balance covers the price. If successful, it deducts the item price from the balance.

```java
class VendingMachine {
    private HashMap<Integer, Item> items;
    private int balance;
    // Constructor, displayItems(), purchaseItem()
}
```

#### `VendingMachineApp` Class
The main class to initialize and run the vending machine simulation, containing:
- `main(String[] args)`: The main method, which prompts the user for initial balance, displays items, processes purchases, and handles user interactions.
- `getValidIntInput(Scanner scanner)`: Helper method to ensure valid integer input.

```java
public class VendingMachineApp {
    public static void main(String[] args) {
        // Initialize vending machine and process transactions
    }
}
```

## Running the Program

1. Clone the repository:
   ```bash
   git clone https://github.com/Y3su/VendingMachine.git
   ```

2. Navigate to the project directory:
   ```bash
   cd VendingMachine
   ```

3. Compile the Java program:
   ```bash
   javac VendingMachineApp.java
   ```

4. Run the program:
   ```bash
   java VendingMachineApp
   ```

## Customization

- You can adjust the initial items and prices in the `VendingMachine` class by modifying the `items` HashMap.
- Change the minimum balance requirement in the `VendingMachineApp` class if desired.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
