package atividade2;
import java.io.PrintStream;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        String fileName = args[0];
        String sub;
        try (
            Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream(fileName);
        ){
            while(sc.hasNextLine()) {
                sub = sc.nextLine();
                if(sub.contains("FIM")){
                    break;
                }
                ps.println(sub);
            }

            System.out.println("O fim foi encontrado!");
        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
