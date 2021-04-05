package fptaptech;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.println("Enter your option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    handleAddNewContact();
                    break;
                case 2:
                    handleFindContactByName();
                    break;
                case 3:
                    handleDisplayContacts();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
            }
        }
    }

    private static void handleDisplayContacts() {
        HashMap<String, Contact> contacts = addressBook.getAddressBook();
        Iterator iterator = contacts.entrySet().iterator();

        System.out.println("Address Book");
        System.out.println(String.format("%-20s| %s", "Contact name", "Phone number"));
        System.out.println("--------------------|-------------------");
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            Contact contact = (Contact) pair.getValue();
            System.out.println(String.format("%-20s| %s", contact.getName() , contact.getPhone()));
        }
        System.out.println();
    }

    private static void handleFindContactByName() {
        System.out.print("Enter the contact name you want to find: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.findByName(name);
        if (contact != null) {
            System.out.println();
            System.out.println(String.format("%-20s| %s", "Contact name", "Phone number"));
            System.out.println("--------------------|-------------------");
            System.out.println(String.format("%-20s| %s", contact.getName() , contact.getPhone()));
            System.out.println();
            return;
        }
        System.out.println("Contact name '" + name + "' not found" );
        System.out.println();
    }

    private static void handleAddNewContact() {
        String name = "";
        do {
            System.out.println("Enter a name: ");
            name = scanner.nextLine();
        } while (name.isEmpty());
        String phone = "";
        do {
            System.out.println("Enter a phone number: ");
            phone = scanner.nextLine();
        } while (phone.isEmpty());

        addressBook.addContact(name, phone);
        System.out.println();
    }
}
