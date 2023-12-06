package atividade3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**Crie uma aplicação em Java que recebe via linha de comando: 
 * (1) o nome de um arquivo CSV; 
 * (2) o delimitador usado para separar os campos do arquivo; 
 * (3) uma lista de nomes das colunas do arquivo CSV que serão processados. 
 * 
 * Considere que o arquivo CSV 
 * (1) deva ter um cabeçalho com os nomes das colunas em sua primeira linha e que não tenha internamente colunas com Strings contendo o mesmo caractere usado como delimitador 
 * (2). A aplicação deve exibir a soma e a média das colunas selecionadas em 
 * (3), caso tenham dados numéricos. Se não tiverem dados numéricos, somente exibir que aquela coluna não é numérica. 
 * Não usar bibliotecas externas para resolver esta questão (usar Java puro). 
*/

public class Q1 {
    public static void main(String[] args) {
        String fileName = args[0];
        String delimitador = args[1];
        String[] colunas = Arrays.copyOfRange(args, 2, args.length);

        try (InputStream is = new FileInputStream(fileName);
             Scanner sc = new Scanner(is)){

                String header = sc.nextLine();
                String[] nomeColunas = header.split(delimitador);
                
                List<Integer> indexColunas = new ArrayList<>();
                for(String coluna : colunas) {
                    int index = -1;
                    for(int i = 0; i < nomeColunas.length; i++){
                        if(coluna.equals(nomeColunas[i])) {
                            index = i;
                            break;
                        }
                    }
                    indexColunas.add(index);
                }

                double[] somas = new double[colunas.length];
                int[] counts = new int[colunas.length];

                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    String[] values = line.split(delimitador);

                    for(int i = 0; i < colunas.length; i++){
                        int index = indexColunas.get(i);

                        if(index >= 0 && index < values.length){
                            try {
                                double value = Double.parseDouble(values[index]);
                                somas[i] += value;
                                counts[i]++;
                            } catch (NumberFormatException e) {
                                
                            }
                        }
                    }
                }

                for(int i = 0; i < colunas.length; i++ ){
                    String coluna = colunas[i];
                    int count = counts[i];
                    double soma = somas[i];

                    if(count > 0){
                        double media = soma / count;
                        System.out.println(coluna + ": soma = " + soma + ", Media = " + media);
                    } else{
                        System.out.println(coluna + ": Nao e numerica");
                    }
                }
            
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}