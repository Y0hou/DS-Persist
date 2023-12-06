package java.dao;

import java.util.List;

import java.entity.Produto;

public interface ProdutoDAO {
	
    public void save(Produto entity);
    
    public void delete(int id);
    
    public Produto find(int id);
    
    public List<Produto> findAll(); 
    
    public Produto findByCodigo(String codigo); 
    
    public List<Produto> findByDescricao(String descricao); 
}
