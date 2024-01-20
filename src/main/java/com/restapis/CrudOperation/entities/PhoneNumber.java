package com.restapis.CrudOperation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restapis.CrudOperation.entities.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@FieldNameConstants
public class PhoneNumber {


    //HomeWork -->
    // EmailAddress -->Entity/Table -->Employee update
    // Address -->
    // Adhar_number column
    //@OneToOne


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneNumberId;

    private long mobileNumber;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    @JsonIgnore
    private Employee employee;


        public String toString3() {
        return "PhoneNumber{" +
                "phoneNumberId=" + phoneNumberId +
                ", mobileNumber=" + mobileNumber +
                '}';
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumberId=" + phoneNumberId +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
