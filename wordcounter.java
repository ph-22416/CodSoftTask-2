import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class wordcounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Enter text directly.");
        System.out.println("2. Provide a file path to read from.");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String content = "";

        if (choice == 1) {
            System.out.println("Enter your text:");
            content = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter file path:");
            String filePath = scanner.nextLine();
            content = readFile(filePath);
            if (content == null) {
                System.out.println("Error reading file.");
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Split the string into an array of words using space or punctuation as delimiters.
        String[] words = content.split("\\W+");

        // Display the total count of words to the user.
        System.out.println("Total word count: " + words.length);

        scanner.close();
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return null;
        }
        return content.toString();
    }
}
