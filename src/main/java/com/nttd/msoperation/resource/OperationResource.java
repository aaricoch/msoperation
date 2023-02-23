package com.nttd.msoperation.resource;

import java.util.List;

import org.jboss.logging.Logger;

import com.nttd.msoperation.dto.OperationDto;
import com.nttd.msoperation.dto.ResponseDto;
import com.nttd.msoperation.entity.Operation;
import com.nttd.msoperation.service.OperationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/operation")
public class OperationResource {

	@Inject
	OperationService operationService;

	@Inject
	Logger logger;
	
	/**
	 * Proceso de una operacion bancaria, pagos, depositos, transferencia
	 * */
	 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@org.eclipse.microprofile.openapi.annotations.Operation(summary = "Registrar las operaciones Bancarias",description = "Permite Registrar las operaciones Bancarias")
	public Response processOperation(OperationDto operationDto) {
		logger.info("Iniciando OperationResource.processOperation");
		logger.info(operationDto.toString());
		ResponseDto responsedto = operationService.processOperation(operationDto);
		return Response.ok(responsedto).status(responsedto.getCode()).build();
	} 
	
	/**
	 * consulta de operaciones bancarias por filtros
	 * flagOperation : D ó R
	 * flag_description: R,D T PC PTC
	 * */
	
	@GET
	@Path("{flagOperation}")
	@Produces(MediaType.APPLICATION_JSON)
	@org.eclipse.microprofile.openapi.annotations.Operation(summary = "Consultar las operaciones bancarias por filtros",description = "Permite consulta de operaciones bancarias por filtros")
	public Response retrieveOperations(@PathParam(value = "flagOperation") String  flagOperation){
		logger.info("Iniciando OperationResource.retrieveOperations");
		OperationDto operationDto = new OperationDto();
		operationDto.setFlagOperation(flagOperation);
		List<Operation> lista = operationService.retrieveOperations(operationDto);
		return Response.ok(lista).status(200).build();
	}

	/* mostrar todas las operaciones */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@org.eclipse.microprofile.openapi.annotations.Operation(summary = "Consultar todas las operaciones bancarias",description = "Permite Consultar todas las operaciones bancarias")
	public Response retrieveOperations(){
		logger.info("Iniciando OperationResource.retrieveOperations");
		List<Operation> lista = operationService.retrieveOperations(new OperationDto());
		return Response.ok(lista).status(200).build();
	}
	
	
	
}
