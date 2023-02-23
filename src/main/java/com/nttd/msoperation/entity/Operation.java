package com.nttd.msoperation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "BQTOPERATION")
public class Operation {
	
	
	@Id
	@SequenceGenerator(
        name = "operationSequence",
        sequenceName = "operation_id_seq",
        allocationSize = 1,
        initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operationSequence")
	private Integer idOperation;
	@Column
	private Double ammount;
	@Column
	private Integer idAOperationOrigin;
	@Column
	private String flagOperation;
	@Column
	private String flagdDescription;
	@Column
	private String description;
	@Column
	private Integer idAccountCustomer;
	
	
	
}
