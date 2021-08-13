package Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static void main(String[] args) throws IOException {
    // refer to IO lecture for help
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }


        List<String> contentReadsFromFile = Files.readAllLines(dataFile);// will read a files content
        List<String> lines = Arrays.asList("testing: 1, 5, 3", "testing: 2, 7, 4"); // create new List of strings
        Files.write(dataFile, lines);

        for (String line: contentReadsFromFile){
            System.out.println(line);
        }


    }
}
