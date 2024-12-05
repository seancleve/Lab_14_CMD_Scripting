import javax.swing.*;
import java.io.*;

public class FileScan {
    public static void main(String[] args) {
        File file = null;

        if (args.length > 0) {
            file = new File("src/" + args[0]); // File assumed to be in the 'src' directory
            if (!file.exists() || file.isDirectory()) {
                System.out.println("Invalid file: " + args[0]);
                return;
            }
        } else {

            JFileChooser fileChooser = new JFileChooser("src");
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }

        processFile(file);
    }

    private static void processFile(File file) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
                wordCount += line.split("\\s+").length;
                charCount += line.length();
            }

            System.out.println("\n--- Summary Report ---");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

