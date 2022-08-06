package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable // JPA 내장 객체
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
