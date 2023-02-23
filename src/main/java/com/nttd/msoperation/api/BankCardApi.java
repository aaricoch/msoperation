package com.nttd.msoperation.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.nttd.msoperation.api.request.BankCardRequest;
import com.nttd.msoperation.api.response.BankCardResponse;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@RegisterRestClient
@Path("/bankcard")
public interface BankCardApi {

    @POST
    public BankCardResponse addBankCard(BankCardRequest bankCardRequest);

    

}
