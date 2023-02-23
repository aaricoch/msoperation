package com.nttd.msoperation.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nttd.msoperation.entity.AccountEntity;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ResponseDto {
    
    private int code;
    private String message;
    private List<AccountEntity> listaccount;
    private AccountEntity account;
    private String errorMessage;
    private String description;
    


    
    public ResponseDto() {
    }



    public ResponseDto(int code,String message) {
        this.code = code;
        this.message = message;
    }

    


    public ResponseDto(int code, String message, AccountEntity account) {
        this.code = code;
        this.message = message;
        this.account = account;
    }



    public ResponseDto(int code, String message, List<AccountEntity> listaccount) {
        this.code = code;
        this.message = message;
        this.listaccount = listaccount;
    }



    public ResponseDto(int code, String errorMessage, String description) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.description = description;
    }


    

}
