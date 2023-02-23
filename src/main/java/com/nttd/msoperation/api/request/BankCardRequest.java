package com.nttd.msoperation.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankCardRequest {

    private String cardnumber;
    private int pin;
    private String duedate;
    private int validationcode;
    
}
