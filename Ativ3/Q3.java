/*
3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:
arquivo config.properties
arquivo = meu_arquivo.txt
linha_inicial = 1
linha_final = 3
Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.
 */

package atividade3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Q3 {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream configFile = new FileInputStream("config.properties")){
            properties.load(configFile);

            String fileName = properties.getProperty("arquivo");
            String start_line = properties.getProperty("linha_inicial");
            String final_line = properties.getProperty("linha_final");

            try (InputStream is = new FileInputStream(fileName);
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr);
            ){
                String line;
                int line_number = 0;

                while ((line = br.readLine()) != null) {
                    line_number++;
                    if (line_number >= Integer.parseInt(start_line) && line_number <= Integer.parseInt(final_line)) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Um erro de leitura ocorreu: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Um erro ao carregar o arquivo de configuração ocorreu: " + e.getMessage());
        }
    }
}
