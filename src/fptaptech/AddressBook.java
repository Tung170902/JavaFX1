package fptaptech;

import java.util.HashMap;
import java.util.List;

public class AddressBook {
    private static HashMap<String, Contact> addressBook = new HashMap<>();

    public AddressBook() {}

    public static void addContact(String name, String phone) {
        addressBook.put(name, new Contact(name, phone));
    }

    public static Contact findByName(String name) {
        return addressBook.get(name);
    }

    public static HashMap<String, Contact> getAddressBook() {
        return addressBook;
    }

}
