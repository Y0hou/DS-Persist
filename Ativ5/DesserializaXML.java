/*
 * Questão 5:
 * Crie uma classe java de nome DesserializaXML para ler / desserializar os objetos Serializados na Questão 4 e exibi-los.
 */

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DesserializaXML {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            File inputFile = new File("atividade.xml");
            List<Atividade> listaAtividade = xmlMapper.readValue(inputFile, xmlMapper.getTypeFactory().constructCollectionType(List.class, Atividade.class));

            for(Atividade atividade : listaAtividade){
                System.out.println("XML");
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
