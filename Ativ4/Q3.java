package atividade4;
/*
 *Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser decriptado e (2) o nome do arquivo resultante da decriptação e (3) a chave de decriptação.
 */
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

import java.io.*;

public class Q3 {

    public static void main(String[] args) {
        String arquivoEncriptado = args[0];
        String arquivoResultante = args[1];
        String chave = args[2];

        try {
            byte[] chaveBytes = chave.getBytes("UTF-8");
            SecretKeySpec chaveSecreta = new SecretKeySpec(chaveBytes, "AES");


            Cipher cifra = Cipher.getInstance("AES");
            cifra.init(Cipher.DECRYPT_MODE, chaveSecreta);

            FileInputStream is = new FileInputStream(arquivoEncriptado);
            FileOutputStream os = new FileOutputStream(arquivoResultante);
            CipherInputStream cis = new CipherInputStream(is, cifra);


            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            cis.close();
            os.close();

        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
