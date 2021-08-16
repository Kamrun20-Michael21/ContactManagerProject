//package Contacts;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class Contact {
////    private String firstName;
////    private String lastName;
////    private int phoneNumber;
////
////    public Contact(String firstName, String lastName, int phoneNumber) {
////        this.firstName = firstName;
////        this.lastName = lastName;
////        this.phoneNumber = phoneNumber;
////    }
//    protected static String directory = "data";
//    protected static String filename = "contacts.txt";
//
//public static Path getContacts() throws IOException {
//    Path dataDirectory = Paths.get(directory);
//    Path contactFile = Paths.get(directory, filename);
//
//    if (Files.notExists(dataDirectory)) {
//        Files.createDirectories(dataDirectory);
//    }
//
//    if (! Files.exists(contactFile)) {
//        Files.createFile(contactFile);
//    }
//
//    return contactFile;
//}
//public static void addContacts(){
//    //method for adding contacts
//}
//public static void displayContacts() throws IOException {
////        System.out.println("Testing displayContacts method");
//    List<String> contentReadsFromFile = Files.readAllLines(getContacts());// will read a files content
//    for (String line: contentReadsFromFile){
//        System.out.println(line);
//    }
//}
//
//    public static void main(String[] args) {
//        // TODO: 8/13/21 create list of strings, iterate through string to
//        //convert from contacts.txt
//
//        //POJO
//        //should rep an instance of each contact
//        //properties, constructors, getters and setters
//
//    }
//}
