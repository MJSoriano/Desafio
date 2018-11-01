package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Pedidos;
import service.PedidosService;
import service.PedidosServiceImpl;

@Path("/Pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PedidosController {
	private static final Logger logger = LoggerFactory.getLogger(PedidosController.class);

	private PedidosService pedidosService;
	
	public PedidosController() {
		pedidosService = new PedidosServiceImpl();
	}
    
    @GET
    public List<Pedidos> getAll() {
        logger.info("getAllVehicles: {}");
        List<Pedidos> ped = pedidosService.getAll();
        return ped;
    }
    
    @GET
    @Path("{id : \\d+}")
    public Response getById(@PathParam("id") Integer id) {
        logger.info("getById : {}", id);
        Pedidos ped = pedidosService.findById(id);
        if (ped == null) {
        	return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(ped).build();
    }
    
    @POST
    public Response savePedido(Pedidos ped) {
        pedidosService.savePedido(ped);
        return Response.ok().build();
    }
    
    
}
