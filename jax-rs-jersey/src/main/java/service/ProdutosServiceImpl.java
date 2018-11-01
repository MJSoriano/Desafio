package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Produtos;

public class ProdutosServiceImpl implements ProdutosService {
	private List<Produtos> prod = new ArrayList<Produtos>();

	private String[] produtos = {"Computador","Televisor","Carro","Barco","Celular"};
	private String[] descricoes = {"Computador completo funcionando", "Televisor com fonte queimada", "Carro funcionando", "Barco sem motor", "Celular sem bateria"};
	private double[] valores = {999.95,50.25,5985.98,17950.0,120.50};
	
	public ProdutosServiceImpl() {
		for (int i = 0; i < 5; i++) {
			Produtos prods = new Produtos();
			prods.setId(i);
			prods.setProduto(produtos[i]);
			prods.setDescricao(descricoes[i]);
			prods.setValor(valores[i]);
			prod.add(prods);
		}
	}
	
	public List<Produtos> getAll() {
		return prod;
	}
	
	public Produtos findById(Integer id) {
        Optional<Produtos> opcao = prod.stream()
        		.filter(produto -> produto.getId().equals(id)).findFirst();

        return opcao.orElse(null);
    }
}
