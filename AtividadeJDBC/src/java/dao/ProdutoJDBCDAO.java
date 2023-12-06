package java.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.entity.Produto;

public class ProdutoJDBCDAO implements ProdutoDAO {

    public ProdutoJDBCDAO() { }
    
    public void save(Produto entity) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "INSERT INTO produtos (codigo, descricao, preco, quantidade_estoque, data_ultima_entrada) VALUES (?, ?, ?, ?, ?)";
            String update_sql = "UPDATE produtos SET codigo = ?, descricao = ?, preco = ?, quantidade_estoque = ?, data_ultima_entrada = ? WHERE id = ?";
            PreparedStatement pst;
            if (entity.getId() == 0) {
                pst = con.prepareStatement(insert_sql);
            } else {
                pst = con.prepareStatement(update_sql);
                pst.setInt(6, entity.getId());
            }
            pst.setString(1, entity.getCodigo());
            pst.setString(2, entity.getDescricao());
            pst.setBigDecimal(3, new BigDecimal(entity.getPreco()));
            pst.setInt(4, entity.getQuantidadeEstoque());
            pst.setString(5, entity.getDataUltimaEntrada());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public void delete(int id) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public Produto find(int id) {
        Connection con = null;
        Produto produto = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT id, codigo, descricao, preco, quantidade_estoque, data_ultima_entrada FROM produtos WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                produto = map(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return produto;
    }

    private Produto map(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setCodigo(rs.getString("codigo"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setPreco(rs.getBigDecimal("preco").doubleValue());
        produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
        produto.setDataUltimaEntrada(rs.getString("data_ultima_entrada"));
        return produto;
    }

    public List<Produto> findAll() {
        Connection con = null;
        List<Produto> result = null;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pst;
            String sql = "SELECT id, codigo, descricao, preco, quantidade_estoque, data_ultima_entrada FROM produtos";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Produto>();
            while (rs.next()) {
                Produto produto = map(rs);
                result.add(produto);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return result;
    }

    public Produto findByCodigo(String codigo) {
        Connection con = null;
        Produto produto = null;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pst;
            String sql = "SELECT id, codigo, descricao, preco, quantidade_estoque, data_ultima_entrada FROM produtos WHERE codigo = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                produto = map(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return produto;
    }

    public List<Produto> findByDescricao(String descricao) {
        Connection con = null;
        List<Produto> result = null;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pst;
            String sql = "SELECT id, codigo, descricao, preco, quantidade_estoque, data_ultima_entrada FROM produtos WHERE UPPER(descricao) LIKE ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + descricao.toUpperCase() + "%");
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Produto>();
            while (rs.next()) {
                Produto produto = map(rs);
                result.add(produto);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return result;
    }
}
