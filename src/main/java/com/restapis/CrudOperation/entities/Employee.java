package com.restapis.CrudOperation.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.Set;

@Entity
@Data
@FieldNameConstants
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String name;

    private String address;

    private String mobNo;

    private  String city;

    private  int salray;

    // we have made phone number unique set
    @OneToMany(fetch = FetchType.EAGER,mappedBy = PhoneNumber.Fields.employee,orphanRemoval = true,
    cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumber;






}
