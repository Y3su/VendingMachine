import java.util.ArrayList;
import java.util.Scanner;

public class merged {
    // Declare two ArrayLists to store names and contacts
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> contacts = new ArrayList<>();

    // Static initializer block to add an initial contact
    static {
        names.add("charlszard");
        contacts.add("09123456789");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object to read user input

        boolean start = true;  // Initialize a boolean variable to control the loop

        // Start a loop to display the menu and handle user input
        while (start) {
            // Display the menu options
            System.out.println("My Contacts \n1. Display all contacts \n2. Find contact \n3. Add contact \n4. Edit contact \n5. Delete contact \n6. Exit");
            System.out.println("Enter your choice: ");
            String choice = sc.nextLine();  // Read the user's choice

            // Handle the user's choice using a switch statement
            switch (choice) {
                case "1":
                    display(sc);  // Call the display method to show all contacts
                    break;
                
                case "2":
                    find(sc);  // Call the find method to search for a contact
                    break;
                
                case "3":
                    add(sc);  // Call the add method to add a new contact
                    break;

                case "4":
                    edit(sc);  // Call the edit method to edit an existing contact
                    break;

                case "5":
                    delete(sc);  // Call the delete method to delete a contact
                    break;

                case "6":
                    System.out.println("Thank you!");  // Exit message
                    return;  // Exit the program
                
                default:
                    System.out.println("Invalid input");  // Handle invalid input
            }
        }
    }

    // Method to display all contacts
    public static void display(Scanner sc) {
        System.out.println("Display all contacts");

        // Loop through the contacts and print them
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + " - " + names.get(i) + " - " + contacts.get(i));
        }
    }

    // Method to find a contact by name or number
    public static void find(Scanner sc) {
        System.out.println("Enter contact name to search: ");
        String contact_search = sc.nextLine().toLowerCase();  // Read the contact name to search

        // Search by contact name
        if (names.contains(contact_search)) {
            int index = names.indexOf(contact_search);
            System.out.println("Contact name: " + names.get(index));
            System.out.println("Phone number: " + contacts.get(index));
        }
        // Search by phone number
        else if (contacts.contains(contact_search)) {
            int index = contacts.indexOf(contact_search);
            System.out.println("Contact name: " + names.get(index));
            System.out.println("Phone number: " + contacts.get(index));
        }
        // No contact found
        else {
            System.out.println("ERROR: No contact information was found");
        }   
    }

    // Method to add a new contact
    public static void add(Scanner sc) {
        System.out.println("Enter new contact name: ");
        String new_name = sc.nextLine();  // Read the new contact name
        
        // Regex to check if the name contains only letters and spaces
        if (!new_name.matches("[a-zA-Z ]+")) {
            System.out.println("ERROR: Name should contain only letters and spaces, and should not be a number or contain special characters.");
        }
        else {
            names.add(new_name);  // Add the new name to the list
            System.out.println("Name added successfully");

            System.out.println("Enter new contact number: ");
            String new_number = sc.nextLine();  // Read the new contact number
        
            // Check if the contact number is valid
            if (new_number.length() != 11 || !new_number.startsWith("09")) {
                System.out.println("ERROR: Phone number should start with '09' and must be 11 numbers long");
            }
            else if (contacts.contains(new_number)) {
                System.out.println("This number is already in your list");
            }
            else {
                contacts.add(new_number);  // Add the new contact number to the list
                System.out.println("Contact added successfully");
            }
        }
    }
    
    // Method to edit an existing contact
    public static void edit(Scanner sc) {
        System.out.println("Enter index number to edit: ");
        int index = sc.nextInt();  // Read the index of the contact to edit
        sc.nextLine();  // Consume the newline character
        
        // Check if the index is valid
        if (index > 0 && index <= contacts.size()) {
            System.out.println("Enter new contact name: ");
            String new_name = sc.nextLine();  // Read the new contact name
            System.out.println("Enter new contact number: ");
            String new_number = sc.nextLine();  // Read the new contact number

            // Check if the contact number is valid
            if ((new_number.length() != 11) || !(new_number.startsWith("09"))) {
                System.out.println("ERROR: Phone number should start with '09' and must be 11 numbers long");
            }
            else if (contacts.contains(new_number)) {
                System.out.println("This number is already in your list");
            }
            else {
                names.set(index - 1, new_name);  // Update the contact name
                contacts.set(index - 1, new_number);  // Update the contact number
                System.out.println("Contacts edited successfully");
            }
        }
        else {
            System.out.println("ERROR: Please enter valid input");
        }  
    }

    // Method to delete a contact
    public static void delete(Scanner sc) {
        System.out.println("Enter index to delete: ");
        int index_delete = sc.nextInt();  // Read the index of the contact to delete
        sc.nextLine();  // Consume the newline character

        // Check if the index is valid
        if (index_delete > 0 && index_delete <= contacts.size()) {
            names.remove(index_delete - 1);  // Remove the contact name
            contacts.remove(index_delete - 1);  // Remove the contact number
            System.out.println(index_delete + " has been deleted from your contacts.");
        }
        else {
            System.out.println("ERROR: Please enter a valid input");
        }
    }
}
