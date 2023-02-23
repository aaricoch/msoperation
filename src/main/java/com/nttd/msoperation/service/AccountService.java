package com.nttd.msoperation.service;


import com.nttd.msoperation.dto.AccountDto;
import com.nttd.msoperation.dto.ResponseDto;

public interface AccountService {
    
    public ResponseDto getAllAccount();

    public ResponseDto getProductsDifCardDebit(long idcustomer,boolean flag_dif_td);

    public ResponseDto getByIdAccount(long id);

    public ResponseDto addAccount(AccountDto accountDto);

    public ResponseDto updateAccount(long id,AccountDto accountDto);

    public ResponseDto deleteAccount(long id);


}
