package java;

import java.util.List;

import javax.swing.JOptionPane;

import java.dao.ProdutoDAO;
import java.dao.ProdutoJDBCDAO;
import java.entity.Produto;

public class Main {

    public static void main(String[] args) {
        ProdutoDAO baseProdutos = new ProdutoJDBCDAO();
        String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por Código\n3 - Remover por Código\n4 - Exibir por Código\n5 - Exibir por id\n6 - Exibir todos\n7 - Exibir todos que contêm determinada descrição\n8 - Sair";
        char opcao = '0';
        do {
            try {
                Produto produto;
                String codigo;
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1': // Inserir
                        produto = new Produto();
                        obterProduto(produto);
                        baseProdutos.save(produto);
                        break;
                    case '2': // Atualizar por Código
                        codigo = JOptionPane.showInputDialog("Digite o Código do produto a ser alterado");
                        produto = baseProdutos.findByCodigo(codigo);
                        obterProduto(produto);
                        baseProdutos.save(produto);
                        break;
                    case '3': // Remover por Código
                        codigo = JOptionPane.showInputDialog("Código");
                        produto = baseProdutos.findByCodigo(codigo);
                        if (produto != null) {
                            baseProdutos.delete(produto.getId());
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o produto não foi encontrado.");
                        }
                        break;
                    case '4': // Exibir por Código
                        codigo = JOptionPane.showInputDialog("Código");
                        produto = baseProdutos.findByCodigo(codigo);
                        listaProduto(produto);
                        break;
                    case '5': // Exibir por id
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        produto = baseProdutos.find(id);
                        listaProduto(produto);
                        break;
                    case '6': // Exibir todos
                        listaProdutos(baseProdutos.findAll());
                        break;
                    case '7': // Exibir todos que contêm determinada descrição
                        String descricao = JOptionPane.showInputDialog("Descrição");
                        listaProdutos(baseProdutos.findByDescricao(descricao));
                        break;
                    case '8': // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (opcao != '8');
    }

    public static void obterProduto(Produto produto) {
        String descricao = JOptionPane.showInputDialog("Descrição", produto.getDescricao());
        String codigo = JOptionPane.showInputDialog("Código", produto.getCodigo());
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço", produto.getPreco()));
        int quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em Estoque", produto.getQuantidadeEstoque()));
        String dataUltimaEntrada = JOptionPane.showInputDialog("Data da Última Entrada", produto.getDataUltimaEntrada());

        produto.setDescricao(descricao);
        produto.setCodigo(codigo);
        produto.setPreco(preco);
        produto.setQuantidadeEstoque(quantidadeEstoque);
        produto.setDataUltimaEntrada(dataUltimaEntrada);
    }

    public static void listaProdutos(List<Produto> produtos) {
        StringBuilder listagem = new StringBuilder();
        for (Produto produto : produtos) {
            listagem.append(produto).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum produto encontrado" : listagem);
    }

    public static void listaProduto(Produto produto) {
        JOptionPane.showMessageDialog(null, produto == null ? "Nenhum produto encontrado" : produto);
    }
}
