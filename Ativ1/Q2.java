import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {
        String fileName = args[0];
        String S = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(S)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        br.close();
    }
}
