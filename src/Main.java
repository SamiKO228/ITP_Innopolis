import java.io.*;

public class Main {
    public static void main(String[] args) {

        String inputFile = "input.txt"; // Replace with your input file name
        String outputFile = "output.txt"; // Replace with your output file name
        try(FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt"))
        {
        try (FileInputStream reader = new FileInputStream("input.txt");
             FileOutputStream writer = new FileOutputStream("output.txt")) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a new line to the output file
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            if (e.getMessage().contains("No such file or directory")) {
                System.err.println("Error: Input file '" + inputFile + "' does not exist.");
            } else if (e.getMessage().contains("Permission denied")) {
                System.err.println("Error: No write permission for output file '" + outputFile + "'.");
            } else {
                System.err.println("Error: An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
