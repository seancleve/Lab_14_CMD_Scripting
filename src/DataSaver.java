import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("Enter user data (leave blank to finish):");
        while (true) {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            if (firstName.isBlank()) break;

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("ID Number (6 digits): ");
            String idNumber = scanner.nextLine().replaceAll("\\D", "").replaceAll("^\\d{0,5}$", "000000").substring(0, 6);
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Year of Birth: ");
            String yearOfBirth = scanner.nextLine();


            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth;
            records.add(record);

            System.out.println("Record added.");
        }


        System.out.print("Enter file name to save (e.g., data.csv): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
