/*
 * 1. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar todos os arquivos e subpastas em um arquivo 
 * compactado com extensão zip.
 */
package atividade4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Q1 {
    public static void main(String[] args){
        String zipName = args[0];
        String folderName = args[1];

        try (FileOutputStream fs = new FileOutputStream(zipName);
             ZipOutputStream zs = new ZipOutputStream(fs);
        ){
            zip(new File(folderName), zs, "");
        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }

    private static void zip(File folder, ZipOutputStream zs, String path) {
        File[] files = folder.listFiles();

        if(files != null){
            for(File file : files){
                if(file.isDirectory()) {
                    zip(file, zs, path + file.getName() + "/");
                } else {
                    try {
                        FileInputStream fs = new FileInputStream(file);
                        ZipEntry zipEntry = new ZipEntry(path + file.getName());
                        zs.putNextEntry(zipEntry);

                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while((bytesRead = fs.read(buffer)) != -1){
                            zs.write(buffer, 0, bytesRead);
                        }

                        fs.close();
                        zs.closeEntry();
                    } catch (Exception e) {
                        System.err.println("Um erro ocorreu: " + e.getMessage());                       
                    }
                }
            }
        }
    }
}
