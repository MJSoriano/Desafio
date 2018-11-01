package service;

import java.util.List;

import model.Produtos;

public interface ProdutosService {
	
	List<Produtos> getAll();

	Produtos findById(Integer id);
}
