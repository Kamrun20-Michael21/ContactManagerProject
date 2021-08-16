package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Data {

    protected static String directory = "data";
    protected static String filename = "contacts.txt";
    private String firstName;
    private String lastName;
    private int phoneNumber;
    protected static Scanner input = new Scanner(System.in);

    //todo uncomment if not working
    public static Path getContacts() throws IOException {
        Path dataDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(contactFile)) {
            Files.createFile(contactFile);
        }

        return contactFile;
    }

    //todo uncomment if not working
    public static void displayContacts() throws IOException {
//        System.out.println("Testing displayContacts method");
        List<String> contentReadsFromFile = Files.readAllLines(getContacts());// will read a files content
        for (String line: contentReadsFromFile){
            System.out.println(line);
        }
    }

//    public static void addContact() {
//        // TODO write contact to contact.txt
//    }
    public static void addContacts() throws IOException {
        List<String> contacts = new ArrayList<>();

        boolean wantsToAddAnotherContact = true;

        do {
            System.out.print("Enter first name: ");
            String firstName = input.next();

            System.out.print("Enter last name: ");
            String lastName = input.next();

            System.out.print("Enter phone number: ");
            String phoneNumber = input.next();

            String contact = String.format("%s|%s %s", firstName, lastName, phoneNumber);

            contacts.add(contact);

            System.out.print("Add another contact? [y/n] ");
            wantsToAddAnotherContact = input.next().toLowerCase().contains("y");
        } while (wantsToAddAnotherContact);

        Files.write(getContacts(), contacts, StandardOpenOption.APPEND);
    }





    public static void main(String[] args) throws IOException {
    // refer to IO lecture for help
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);//
        Path contactFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(contactFile)) {
            Files.createFile(contactFile);
        }


        List<String> contentReadsFromFile = Files.readAllLines(contactFile);// will read a files content
        List<String> lines = Arrays.asList("testing: 1, 5, 3", "Java is hard"); // create new List of strings
        Files.write(contactFile, lines);

//        for (String line: contentReadsFromFile){
//            System.out.println(line);
//        }

        displayContacts();//todo uncomment


        //alternative to our Enhanced for loop
//        for (int i = 0; i < lines.size(); i++) {
//            System.out.println((i+1)+": "+lines.get(i));
//        }
        //TODO: method that shows all contacts (checked)
        //TODO: Add new contact method
        //TODO: Search contact by name
        //TODO: delete existing contact


        // *********************END OF MAIN METHOD*********************
    }
    // *********************END OF DATA Class*********************
}
