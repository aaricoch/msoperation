package com.nttd.msoperation.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.nttd.msoperation.api.request.CustomerRequest;
import com.nttd.msoperation.api.response.CustomerResponse;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@RegisterRestClient
@Path("/customer")
public interface CustomerApi {
    
    @POST
    public CustomerResponse addCustomer(CustomerRequest customer);


}
