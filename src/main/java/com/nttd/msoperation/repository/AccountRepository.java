package com.nttd.msoperation.repository;

import com.nttd.msoperation.entity.AccountEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository  implements PanacheRepository<AccountEntity>{
    
    
}
