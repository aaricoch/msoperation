package com.nttd.msoperation.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankCardResponse {

    private int code;
    private String message;
    private String errorMessage;
    private String description;
    private BankCardObject bankCardEntity;

}
