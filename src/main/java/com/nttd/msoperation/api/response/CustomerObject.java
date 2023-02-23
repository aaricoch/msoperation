package com.nttd.msoperation.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerObject {
    
    private Long  idCustomer;
	private String typeCustomer;
	private String numberDocument;
	private String name;
	private String lastname;

}
