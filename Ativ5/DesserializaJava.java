
/* 
 * Questão 3:
 * Crie uma classe java de nome DesserializaJava para ler / desserializar os objetos Serializados na Questão 2 e exibi-los. 
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DesserializaJava  {
    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("atividade.ser");
            ObjectInputStream ois = new ObjectInputStream(is);

            List<Atividade> listAtividades = (List<Atividade>) ois.readObject();

            ois.close();
            is.close();

            for (Atividade atividade : listAtividades) {
                System.out.println("JAVA");
                System.out.println("ID: " + atividade.getId());
                System.out.println("Titulo: " + atividade.getTitulo());
                System.out.println("Data: " + atividade.getData());
                System.out.println("Hora: " + atividade.getHora());
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
