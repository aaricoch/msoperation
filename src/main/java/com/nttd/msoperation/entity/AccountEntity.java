package com.nttd.msoperation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "BQMACCOUNTCUSTOMER")
public class AccountEntity {

    @Id
    @SequenceGenerator(
        name = "accountSequence",
        sequenceName = "account_id_seq",
        allocationSize = 1,
        initialValue = 9)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSequence")
    private long IdAccountCustomer;
    @Column
    private String flag_creation;
    @Column
    private double current_amount;
    @Column
    private double starting_amount;
    @Column
    private String description;
    @Column
    private String flag_account;
    @Column
    private String startdate;
    @Column
    private String courtdate;    
    @Column
    private int quota;
    @Column
    private String paymentdate;
    
    @Column
    private String state;

    @Column
    private String accountnumber;

    @Column
    private long IdCustomer;
    @Column
    private long IdBANKCARD;
    
}
