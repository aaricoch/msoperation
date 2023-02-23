package com.nttd.msoperation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.nttd.msoperation.dto.OperationDto;
import com.nttd.msoperation.dto.ResponseDto;
import com.nttd.msoperation.entity.AccountEntity;
import com.nttd.msoperation.entity.Operation;
import com.nttd.msoperation.repository.AccountRepository;
import com.nttd.msoperation.repository.OperationRepository;
import com.nttd.msoperation.service.OperationService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OperationServiceImpl implements OperationService {

	@Inject
	OperationRepository operationRepository;
	
	@Inject
	AccountRepository accountRepository;
	
	@ConfigProperty(name = "exception.general")
    String exceptionGeneral;
    
    @ConfigProperty(name = "mensaje.general")
    String mensajeGeneral;

	/*
	 * proceso para persistir la operacion en la base de datos
	 * 
	 * */
	@Override
	@Transactional
	public ResponseDto processOperation(OperationDto operationDto) {
		try {
			
			if( operationDto.getDescription().equals("R") ||
				operationDto.getDescription().equals("D")) {
				operationDto.setFlagOperation(operationDto.getDescription());
				operationDto.setIdAOperationOrigin(null);
				saveOperation(operationDto);
			}else{
				// registrando  retiro cuenta origen
				operationDto.setIdAOperationOrigin(null);
				operationDto.setFlagOperation("R");
				Operation operacionOrigen =	saveOperation(operationDto);
				// registrando  retiro cuenta destino
				operationDto.setFlagOperation("D");
				operationDto.setIdAccountCustomer(operationDto.getIdAccountCustomerDestiny());
				operationDto.setIdAOperationOrigin(operacionOrigen.getIdOperation());
				saveOperation(operationDto);
			}

			return new ResponseDto(201, mensajeGeneral);
		} catch (Exception ex) {
			return new ResponseDto(400, exceptionGeneral, ex.getMessage());
		}
	}

	/**
	 * registra la operacion en la base de datos
	 */
	private Operation saveOperation(OperationDto operationDto) {
		Operation operationEntity = new Operation();
		operationEntity.setAmmount(operationDto.getAmmount());
		operationEntity.setIdAOperationOrigin(operationDto.getIdAOperationOrigin());
		operationEntity.setFlagOperation(operationDto.getFlagOperation());
		operationEntity.setFlagdDescription(operationDto.getFlagdDescription());
		operationEntity.setDescription(operationDto.getDescription());
		operationEntity.setIdAccountCustomer(operationDto.getIdAccountCustomer());
		operationRepository.persist(operationEntity);
		
		AccountEntity accountEntity =  accountRepository.findById(Long.valueOf(operationEntity.getIdAccountCustomer()));
		if("R".equals(operationDto.getFlagOperation())) {
			accountEntity.setCurrent_amount(accountEntity.getCurrent_amount()-operationDto.getAmmount());
		} else {
			accountEntity.setCurrent_amount(accountEntity.getCurrent_amount()+operationDto.getAmmount());
		}
		
		accountRepository.persist(accountEntity);
		
		return operationEntity;
	}

	
	/***
	 * 
	 * obtener las operaciones registras , depositos, retiros transferencias, creditos , etc
	 * */
	
	public List<Operation> retrieveOperations(OperationDto filter) {
		// parametros que se pueden ir agregando
		Map<String, Object> parametros = new HashMap<>();
		if (filter.getFlagOperation() != null && filter.getFlagOperation().length()!=0)
			parametros.put("flagOperation", filter.getFlagOperation());

		if (parametros.isEmpty())
			return operationRepository.listAll();

		String query = parametros.entrySet().stream().map(entry -> entry.getKey() + "=:" + entry.getKey())
				.collect(Collectors.joining(" and "));

		return operationRepository.list(query, parametros);
		
		

	}
	
	
	
	
	

}
