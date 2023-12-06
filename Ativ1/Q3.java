import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {
    public static void main(String[] args) {
        String file1Name = args[0];
        String file2Name = args[1];

        processFile(file1Name);
        processFile(file2Name);
        br.close();
    }

    private static void processFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading " + fileName + ": " + e.getMessage());
        }
    }
}
