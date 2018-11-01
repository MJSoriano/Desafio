package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Produtos;
import service.ProdutosService;
import service.ProdutosServiceImpl;

@Path("/Produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProdutosController {
	private static final Logger logger = LoggerFactory.getLogger(ProdutosController.class);

	private ProdutosService produtosService;
	
	public ProdutosController() {
		produtosService = new ProdutosServiceImpl();
	}
	
	@GET
    public List<Produtos> getAll() {
        logger.info("getallProdutos: {}");
        List<Produtos> prod = produtosService.getAll();
        return prod;
    }
	
	@GET
    @Path("{id : \\d+}")
    public Response getById(@PathParam("id") Integer id) {
        logger.info("getById : {}", id);
        Produtos prod = produtosService.findById(id);
        if (prod == null) {
        	return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(prod).build();
    }
	
	
}
