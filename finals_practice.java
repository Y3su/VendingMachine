import java.util.Scanner;
import java.util.ArrayList;

public class finals_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<String>() {{
            add("charlszard");
        }};

        ArrayList<String> contacts = new ArrayList<String>() {{
            add("09123456789");
        }};

        boolean start = true;

        while (start) {
            System.out.println("My Contacts \n1. Display all contacts \n2. Find contact \n3. Add contact \n4. Edit contact \n5. Delete contact \n6. Exit");
            System.out.println("Enter your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.println("Display all contacts");

                //will display all the contacts from variable (names and contacts)
                for (int i = 0; i < names.size(); i++) {
                    System.out.println((i + 1) + " - " + names.get(i) + " - " + contacts.get(i));
                }
            }

            else if (choice.equals("2")) {
                System.out.println("Enter contact name to search: ");
                String contact_search = sc.nextLine().toLowerCase();
                
                if (names.contains(contact_search)) {
                    System.out.println("Contact name: " + names.get(names.indexOf(contact_search)));
                    System.out.println("Phone number: " + contacts.get(contacts.indexOf(contact_search)));
                }
                
                else {
                    System.out.println("ERROR: No contact information was found");
                }
            }

            else if (choice.equals("3")) {
                System.out.println("Enter contact name: ");
                String contact_name = sc.nextLine();
                System.out.println("Enter contact number: ");
                String contact_number = sc.nextLine();

                if ((contact_number.length() == 11) && (contact_number.startsWith("09"))) {
                    if (contacts.contains(contact_number)) {
                        System.out.println("ERROR: This number is already in your contacts lists");
                    }

                    else {
                        names.add(contact_name);
                        contacts.add(contact_number);
                        System.out.println(contact_name + " had been added to your contacts");
                    }
                }

                else {
                    System.out.println("ERROR: Phone number should start with '09' and must be 11 numbers long");
                }
            }

            else if (choice.equals("4")) {
                System.out.println("Enter index number to edit: ");
                int index = sc.nextInt();
                sc.nextLine();
                
                if (index > 0 && index <= contacts.size()) {
                    System.out.println("Enter new contact name: ");
                    String new_name = sc.nextLine();
                    System.out.println("Enter new contact number: ");
                    String new_number = sc.nextLine();

                    if ((new_number.length() != 11) && !(new_number.startsWith("09"))) {
                        System.out.println("ERROR: Phone number should start with '09' and must be 11 numbers long");
                    }
                    
                    else {
                        if (contacts.contains(new_number)) {
                            System.out.println("This number is already in your list");
                        }
                        
                        else {
                            names.add(index - 1, new_name);
                            names.remove(index);
                            contacts.add(index - 1, new_number);
                            contacts.remove(index);
                            System.out.println("Contacts edited successfully");
                        }
                    }   
                }

                else {
                    System.out.println("ERROR: Please eneter valid input");
                }  
            }

            else if (choice.equals("5")) {
                System.out.println("Enter index to delete: ");
                int index_delete = sc.nextInt();

                if (index_delete > 0 && index_delete <= contacts.size()) {
                    names.remove(index_delete - 1);
                    contacts.remove(index_delete - 1);
                    System.out.println(index_delete + " has beed deleted to your contacts.");
                }

                else {
                    System.out.println("ERROR: Please enter invalid input");
                }
            }

            else if (choice.equals("6")) {
                System.out.println("Thank you!");
                break;
            }

            else {
                System.out.println("Invalid input");
            }
        }
    }
}
