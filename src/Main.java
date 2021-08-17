//import Contacts.Contact;
import Contacts.Data;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String[] menu = {
            "1. View contacts.",
            "2. Add a new contact.",
            "3. Search a contact by name.",
            "4. Delete an existing contact.",
            "5. Exit."
    };

    public static void displayMenu() {
        System.out.println("\n****** Main MENU ******");
        for (String item : menu) {
            System.out.println(item);
        }
        System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
    }

    public static void main(String[] args) throws IOException {
//        System.out.println("Will print some message");
//        Contact.contactApp();
        Scanner input = new Scanner(System.in);
        int menuChoice;

        do {
            displayMenu();// display of menu options 1-5
            menuChoice = input.nextInt();//accepts user input int
            switch (menuChoice) {
                case 1:
                    System.out.println();
                    Data.displayContacts(Data.getAllContacts());// display all contacts
                    //Alt option if method is in contact class: Contact.displayContacts();
                    break;
                case 2:
//                    System.out.println("Add contacts");
                    Data.addContacts();//Contact.addContacts()
                    // call add contact method
                    break;
                case 3:
//                    System.out.println("Search contacts");
                    List<String> contactSearch = Data.findContact();
                    if (contactSearch.size() == 0){
                        System.out.println("----- Sorry, name search results -----\n");
//            contacts.add("----- Sorry, name search results -----\n");// THIS WILL NOT WORK
                    } else {
                        Data.displayContacts(contactSearch);//Data.displayContacts(Data.findContact()); old way
                    }

                    break;
                case 4:
//                    System.out.println("Delete contacts");
                    Data.deleteContact();
                    // call delete contact method
                    break;
                case 5:
                    System.out.println("\nExiting Program, Goodbye.");
                    // exit
                    break;
                default:
                    System.out.println("That is not a valid entry, please enter a valid selection.");
            }
        } while (menuChoice != 5);
    }
    // contactApp can be defined
}
