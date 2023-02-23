package com.nttd.msoperation.repository;

import com.nttd.msoperation.entity.Operation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperationRepository  implements PanacheRepository<Operation> {

}
