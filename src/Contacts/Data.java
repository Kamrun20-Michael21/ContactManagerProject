package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.PublicKey;
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

    public static List<String> getAllContacts() throws IOException {
        return Files.readAllLines(getContacts());
    }

    //todo uncomment if not working
    public static void displayContacts(List<String> contactsList) throws IOException {
//        System.out.println("Testing displayContacts method");
        System.out.println("\tName     |     Phone Number");
        System.out.println("\t---------------------------");
        for (String line: contactsList){
            System.out.println(formatContact(line));
        }
    }

    public static String formatContact(String contactFileLine) {
        String[] contactInfo = contactFileLine.split(" ");

        String firstName = contactInfo[0];
        String lastName = contactInfo[1];
        String phoneNumber = contactInfo[2];

        return String.format("%s %s \t|\t %s", firstName, lastName, phoneNumber);
    }

//    public static void addContact() {
//        // TODO write contact to contact.txt
//    }
    public static void addContacts() throws IOException {
        List<String> contacts = new ArrayList<>();

        boolean wantsToAddAnotherContact = true;

        do {
            System.out.print("Enter first name: ");// 1st entry
            String firstName = input.next();

            System.out.print("Enter last name: ");// 2nd entry
            String lastName = input.next();

            System.out.print("Enter phone number: ");// 3rd entry
            String phoneNumber = input.next();

            String contact = String.format("%s %s %s", firstName, lastName, phoneNumber);

            contacts.add(contact);

            System.out.print("Add another contact? [y/n] ");
            wantsToAddAnotherContact = input.next().toLowerCase().contains("y");//HACK:: WORKS WITH MAYBE, NOT JUST YES!!!!
        } while (wantsToAddAnotherContact);

        Files.write(getContacts(), contacts, StandardOpenOption.APPEND);
    }

    public static List<String> findContact() throws IOException {
        List<String> contentReadsFromFile = Files.readAllLines(getContacts());
        List<String> contacts = new ArrayList<>();

        System.out.print("Enter name: ");
        String name = input.next();

        for (String line : contentReadsFromFile) {
            if (line.toLowerCase().contains(name.toLowerCase())) {
                contacts.add(line);
            }
        }

        return contacts;
    }

    public static void deleteContact() throws IOException {
        List<String> contentReadsFromFile = Files.readAllLines(getContacts());
        List<String> contacts = new ArrayList<>();

        for (String contact: contentReadsFromFile){
            contacts.remove(contact);
        }
        Files.write(getContacts(), contacts);
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

//        displayContacts();//todo uncomment


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
