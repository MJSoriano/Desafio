package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Pedidos;

public class PedidosServiceImpl implements PedidosService{
	private List<Pedidos> pedido = new ArrayList<Pedidos>();
	
	public PedidosServiceImpl() {
		Pedidos ped = new Pedidos();
		ped.setId(1);
		ped.setEmail("soriano.mateus@outlook.com");
		ped.setProduto(4);
		pedido.add(ped);
	}
			
	public List<Pedidos> getAll() {
		return pedido;
	}
	
	public Pedidos findById(Integer id) {
        Optional<Pedidos> opcao = pedido.stream()
        		.filter(ped -> ped.getId().equals(id)).findFirst();

        return opcao.orElse(null);
    }

    public Pedidos savePedido(Pedidos ped) {
    	pedido.add(ped);
    	EnviarEmail(ped);
        return ped;
    }
    
    private void EnviarEmail(Pedidos ped)
    {
    	final String fromEmail = "soriano.dev.2016@gmail.com";
		final String password = "unitedfederationofplanets@24";
		final String toEmail = ped.getEmail();
		
		EmailConfig config = new EmailConfig();
		
		config.sendEmail(fromEmail, password, toEmail, 
				"Pedido realizado", "O pedido número " + ped.getId() + " foi realizado com sucesso. O Id do produto pedido foi " + ped.getProduto());
		System.out.println("Enviado");
    }
    
    public void deleteById(Integer id) {
    	this.pedido.removeIf(ped -> ped.getId().equals(id));
    }
}