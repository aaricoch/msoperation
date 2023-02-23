package com.nttd.msoperation.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    
    private String typeCustomer;
	private String numberDocument;
	private String name;
	private String lastname;

}
