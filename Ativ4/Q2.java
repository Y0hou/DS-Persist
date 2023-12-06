package atividade4;
/*
 *Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser encriptado, (2) o nome do arquivo encriptado a ser criado e (3) a chave de encriptação.
 */
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import java.io.*;

public class Q2 {

    public static void main(String[] args) {
        String arquivoOriginal = args[0];
        String arquivoEncriptado = args[1];
        String chave = args[2];

        try {
            byte[] chaveBytes = chave.getBytes("UTF-8");
            SecretKeySpec chaveSecreta = new SecretKeySpec(chaveBytes, "AES");

            Cipher cifra = Cipher.getInstance("AES");
            cifra.init(Cipher.ENCRYPT_MODE, chaveSecreta);

            FileInputStream is = new FileInputStream(arquivoOriginal);
            FileOutputStream os = new FileOutputStream(arquivoEncriptado);
            CipherOutputStream cos = new CipherOutputStream(os, cifra);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }

            is.close();
            cos.close();

        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
