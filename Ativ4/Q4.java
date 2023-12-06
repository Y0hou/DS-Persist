package atividade4;
/*
 Crie uma aplicação em Java que recebe via linha de comando o nome de um arquivo para geração/armazenamento dos hashes  md5, sha1 e sha256 do arquivo especificado. 
 A aplicação deve mostrar o tempo de execução de cada uma dessas operações.
 */
import java.io.*;
import java.security.MessageDigest;

public class Q4 {
    public static void main(String[] args) {
        String fileName = args[0];

        try {
            File file = new File(fileName);

            if(!file.exists()){
                System.out.println("O arquivo não existe.");
                return;
            }

            long starTimeMD5 = System.currentTimeMillis();
            String md5HString = hashCalculate(file, "MD5");
            long endTimeMD5 = System.currentTimeMillis();

            long starTimeSHA1 = System.currentTimeMillis();
            String sha1HString = hashCalculate(file, "SHA-1");
            long endTimeSHA1 = System.currentTimeMillis();

            long starTimeSHA256 = System.currentTimeMillis();
            String sha256HString = hashCalculate(file, "SHA-256");
            long endTimeSHA256 = System.currentTimeMillis();

            System.out.println("MD5: " + md5HString);
            System.out.println("Tempo MD5: " + (endTimeMD5 - starTimeMD5) + "ms");

            System.out.println("SHA-1: " + sha1HString);
            System.out.println("Tempo SHA-1: " + (endTimeSHA1 - starTimeSHA1) + "ms");

            System.out.println("SHA-256: " + sha256HString);
            System.out.println("Tempo SHA-256: " + (endTimeSHA256 - starTimeSHA256) + "ms");
            
        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }

    private static String hashCalculate(File file, String algorithm) throws Exception {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            FileInputStream is = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int bytesRead;
            while((bytesRead = is.read(buffer)) != -1){
                digest.update(buffer, 0, bytesRead);
            }

            is.close();

            byte[] hashBytes = digest.digest();

            StringBuilder hashStringBuilder = new StringBuilder();
            for(byte hashByte : hashBytes ){
                hashStringBuilder.append(Integer.toString((hashByte & 0xff) + 0x100, 16));
            }

            return hashStringBuilder.toString();
    }   
}
