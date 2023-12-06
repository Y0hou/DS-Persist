/*
 * Questão 7:
 * Crie uma classe java de nome DesserializaJSON para ler / desserializar os objetos Serializados na Questão 6 e exibi-los.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DesserializaJSON {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File inputFile = new File("atividade.json");
            List<Atividade> listAtividades = objectMapper.readValue(inputFile, new TypeReference<List<Atividade>>() {});
            
            for(Atividade atividade : listAtividades){
                System.out.println("JSON");
                System.out.println("ID: " + atividade.getId());
                System.out.println("Titulo: " + atividade.getTitulo());
                System.out.println("Data: " + atividade.getData());
                System.out.println("Hora: " + atividade.getHora());
                System.out.println("=====================================");
            }
        } catch (IOException e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
