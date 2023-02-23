package com.nttd.msoperation.service;

import java.util.List;

import com.nttd.msoperation.dto.OperationDto;
import com.nttd.msoperation.dto.ResponseDto;
import com.nttd.msoperation.entity.Operation;

public interface OperationService {
	 public ResponseDto processOperation(OperationDto operationDto);
	 public List<Operation> retrieveOperations(OperationDto filter);
}
