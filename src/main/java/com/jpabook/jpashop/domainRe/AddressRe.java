package com.jpabook.jpashop.domainRe;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class AddressRe {

    private String city;
    private String street;
    private String zipcode;

    protected AddressRe() {

    }

    public AddressRe(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
