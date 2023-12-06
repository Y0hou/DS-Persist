package atividade2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        String fileName = args[0];
        String fileName2 = args[1];
        
        try(FileInputStream is = new FileInputStream(fileName);
            FileOutputStream io = new FileOutputStream(fileName2);
        ){
            long start = System.currentTimeMillis();
            int byteRead;
            
            while((byteRead = is.read()) != -1){
                io.write(byteRead);
            }
            long end = System.currentTimeMillis();
            long total = end - start;

            System.out.println("Arquivo copiado!");
            System.out.println("Tempo decorrido: " + total + "ms");
            
        } catch (IOException e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}