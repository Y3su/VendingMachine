import java.util.ArrayList;
import java.util.Scanner;

public class Lariosa_LoginAndRegistration {
    // ArrayLists to store usernames and passwords
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();

    // Static block to add the default admin account
    static {
        usernames.add("admin");
        passwords.add("admin123");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        while (true) { // Infinite loop to keep the program running
            // Display the menu options
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); // Read the user's choice
            scanner.nextLine();  // Consume the newline character

            // Handle the user's choice
            switch (choice) {
                case 1:
                    register(scanner); // Call the register method
                    break;
                case 2:
                    login(scanner); // Call the login method
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method for user registration
    public static void register(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine(); // Read the username

        if (isUsernameTaken(username)) { // Check if the username is already taken
            System.out.println("ERROR: Username already taken.");
            return; // Exit the method if the username is taken
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine(); // Read the password

        if (!isPasswordValid(password)) { // Validate the password
            return; // Exit the method if the password is not valid
        }

        usernames.add(username); // Add the username to the list
        passwords.add(password); // Add the password to the list
        System.out.println("Registration successful!");
    }

    // Method to check if a username is already taken (case-sensitive)
    public static boolean isUsernameTaken(String username) {
        // Iterate over the list of usernames to check for a match
        for (String registeredUsername : usernames) {
            if (registeredUsername.equals(username)) {
                return true; // Return true if a match is found
            }
        }
        return false; // Return false if no match is found
    }

    // Method to validate the password
    public static boolean isPasswordValid(String password) {
        // Check if the password length is between 8 and 12 characters
        if (password.length() < 8 || password.length() > 12) {
            System.out.println("ERROR: Password must be 8–12 characters.");
            return false; // Return false if the length condition is not met
        }

        boolean hasLetter = false; // Flag to check if there is a letter
        boolean hasNumber = false; // Flag to check if there is a number
        boolean hasSymbol = false; // Flag to check if there is a symbol

        // Check each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true; // Check for letters
            else if (Character.isDigit(c)) hasNumber = true; // Check for numbers
            else hasSymbol = true; // Check for symbols
        }

        // Check if all conditions are met
        if (!hasLetter) {
            System.out.println("ERROR: Password must be at least one letter.");
            return false;
        }
        if (!hasNumber) {
            System.out.println("ERROR: Password must be at least one number.");
            return false;
        }
        if (!hasSymbol) {
            System.out.println("ERROR: Password must be at least one symbol.");
            return false;
        }

        return true; // Return true if all conditions are met
    }

    // Method for user login
    public static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine(); // Read the username
        System.out.print("Enter your password: ");
        String password = scanner.nextLine(); // Read the password

        if (authenticate(username, password)) { // Authenticate the user
            if (username.equals("admin")) { // Check if the user is admin
                viewAllUsers(); // Call the viewAllUsers method for admin
            } else {
                System.out.println("Login successful! Welcome, " + username + ".");
            }
        } else {
            System.out.println("ERROR: Invalid username or password.");
        }
    }

    // Method to authenticate the user
    public static boolean authenticate(String username, String password) {
        int index = usernames.indexOf(username); // Get the index of the username
        // Check if the username exists and the password matches
        return index != -1 && passwords.get(index).equals(password);
    }

    // Method to view all registered users
    public static void viewAllUsers() {
        System.out.println("Registered Users:");
        // Iterate over all users and print their usernames
        for (int i = 0; i < usernames.size(); i++) {
            if (!usernames.get(i).equals("admin")) { // Exclude the admin account
                System.out.println(usernames.get(i));
            }
        }
    }
}
