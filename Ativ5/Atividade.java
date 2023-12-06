
/*
 * Questão 1:
 * Crie uma classe Java de entidade. Escolha uma entidade que você já propôs para seu Trabalho Prático. 
 * Exemplo: classe Filme (id, titulo, sinopse, diretor). A classe deve implementar a interface java.io.Serializable. 
 * Crie também uma classe que possua uma lista de objetos da entidade escolhida.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Atividade implements Serializable {
    private int id;
    private String titulo;
    private String data;
    private String hora;

    public Atividade(int id, String titulo, String data, String hora){
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
    }

    public Atividade() {

    }


    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }   

    public String getData(){
        return this.data;
    }   

    public String getHora(){
        return this.hora;
    }

    public static class ListAtividade implements Serializable {
        private List<Atividade> atividades;

        public ListAtividade(){
            this.atividades = new ArrayList<>();
        }

        public void addAtividade(Atividade atividade){
            this.atividades.add(atividade);
        }

        public List<Atividade> getAtividades(){
            return this.atividades;
        }
    }
}
