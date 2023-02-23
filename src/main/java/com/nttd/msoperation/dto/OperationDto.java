package com.nttd.msoperation.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperationDto {
	
	
	private Integer idOperation;
	private Double ammount;
	private Integer idAOperationOrigin;
	private String flagOperation;
	private String flagdDescription;
	private String description;
	private Integer idAccountCustomer;
	private Integer idAccountCustomerDestiny;
	
	
	
}
