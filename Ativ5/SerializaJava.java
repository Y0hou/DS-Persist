
/* Questão 2:
 * Crie uma classe Java de nome SerializaJava para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. 
 * Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando a Serialização de objetos da própria API Java.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializaJava {
    public static void main(String[] args) {
        Atividade atividade1 = new Atividade(1, "Aula DSPersist", "2023-09-18", "08:00");
        Atividade atividade2 = new Atividade(2, "Aula Requisistos de Software", "2023-09-18", "10:00");
        Atividade atividade3 = new Atividade(3, "Aula Redes de Computadores", "2023-09-19", "10:00");
        Atividade atividade4 = new Atividade(4, "Aula Etica", "2023-09-20", "13:30");

        List<Atividade> listAtividade = new ArrayList<>();

        listAtividade.add(atividade1);
        listAtividade.add(atividade2);
        listAtividade.add(atividade3);
        listAtividade.add(atividade4);

        try {
            FileOutputStream os = new FileOutputStream("atividade.ser");
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(listAtividade);

            oos.close();
            os.close();

            System.out.print("Serializado com sucesso");
            System.out.print(" ");
        } catch (Exception e) {
            System.err.println("Um erro ocorreu: " + e.getMessage());
        }
    }
}
