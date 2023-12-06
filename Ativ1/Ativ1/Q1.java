import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        String fileName = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            for (int i = 0; i < 10; i++){
                line = br.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        br.close();
    }
}
