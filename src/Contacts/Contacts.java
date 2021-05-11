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

public class Contacts {


    //print file method
    public static void printFile(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("\n%d %s", i + 1, fileContents.get(i)); //each line

//            System.out.println();
        }
    }

    //Search method
    public static void searchFile(Path filePath) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the name you would like to search for");
        String input = sc.nextLine();

        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            if (fileContents.get(i).contains(input)){
                System.out.printf("%d %s", i + 1, fileContents.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //********SCANNER**********
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "What would you like to do?\n" +
                        "\n" +
                        "1. View contacts.  \n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Exit.\n" +
                        "\n" +
                        "Enter an option (1, 2, 3, 4 or 5): "
        );

        System.out.println();
        //Print file

        Path filepathtoList = Paths.get("./src/Contacts/Contacts-List.txt");


        //System.out.println("filepathtoList = " + filepathtoList);
        //System.out.println("Files.exists() = " + Files.exists(filepathtoList));
//        printFile(filepathtoList);

        //Setting up file path

        String directory = "./src/Contacts";

        String filename = "Contacts-List.txt";

        Path dataDirectory = Paths.get(directory);

        Path dataFile = Paths.get(directory);

        //System.out.println("dataFile = " + dataFile);

        if (Files.notExists(dataDirectory)) {

            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {

            Files.createFile(dataFile);
        }

        //APPEND to contact list
        Path contactPath = Paths.get(directory, filename);

        //System.out.println("contactPath = " + contactPath);

//        List<String> newContact = Arrays.asList("###-###-####");
//        //System.out.println("newContact = " + newContact);
//
//        Files.write(contactPath, newContact, StandardOpenOption.APPEND);


        //**********GET INPUT***********

        Scanner inputScanner = new Scanner(System.in);
        int input;
        do {
            input = inputScanner.nextInt();
            switch (input) { //DISPLAY
                case 1:
                    printFile(filepathtoList);
                    break;
                case 2: //ADD
                    System.out.println("[Name Number]");
                    String name = sc.next();
                    String newNumber = sc.next();

                    List<String> newContact = Arrays.asList(name + " | " + newNumber);
                    Files.write(contactPath, newContact, StandardOpenOption.APPEND);
                    break;
                case 3: //SEARCH
                    searchFile(filepathtoList);
                    break;
                case 4: //DELETE

                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        } while (input != 5);

    }
}
