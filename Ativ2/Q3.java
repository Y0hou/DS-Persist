package atividade2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        String modo = args[0];
        String fileName1 = args[1];
        String fileName2 = args[2];

        try {
            if ("iso2utf".equalsIgnoreCase(modo)) {
                convertISOtoUTF(fileName1, fileName2);
            } else if ("utf2iso".equalsIgnoreCase(modo)) {
                convertUTFtoISO(fileName1, fileName2);
            } else {
                System.out.println("Modo inválido. Use 'iso2utf' ou 'utf2iso'.");
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public static void convertISOtoUTF(String inputFile, String outputFile) throws IOException {
        try (FileInputStream is = new FileInputStream(inputFile);
             Scanner sc = new Scanner(is, "ISO-8859-1");
             FileOutputStream os = new FileOutputStream(outputFile);
             PrintStream ps = new PrintStream(os, true, StandardCharsets.UTF_8);
        ) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ps.println(line);
            }
            System.out.println("Arquivo convertido de ISO-8859-1 para UTF-8!");
        }
    }

    public static void convertUTFtoISO(String inputFile, String outputFile) throws IOException {
        try (FileInputStream is = new FileInputStream(inputFile);
             Scanner sc = new Scanner(is, StandardCharsets.UTF_8);
             FileOutputStream os = new FileOutputStream(outputFile);
             PrintStream ps = new PrintStream(os, true, "ISO-8859-1");
        ) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ps.println(line);
            }
            System.out.println("Arquivo convertido de UTF-8 para ISO-8859-1!");
        }
    }
}
