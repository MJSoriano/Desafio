package service;

import java.util.List;

import model.Pedidos;

public interface PedidosService {
	List<Pedidos> getAll();

	Pedidos findById(Integer id);

	Pedidos savePedido(Pedidos ped);
}
