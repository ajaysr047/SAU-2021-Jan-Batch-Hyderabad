package com.asr.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String streetName;

    private String city;

    private int pinCode;

    private int employeeId;

    public Address(String streetName, String city, int pinCode) {
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }
}
