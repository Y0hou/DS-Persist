package entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
    private String nome;
    private Integer id;
    private String codigo; 
    private String descricao; 
    private double preco; 
    private int quantidadeEstoque;
    private Date dataUltimaEntrada; 
}
