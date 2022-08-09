package com.jpabook.jpashop.domainRe;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class MemberRe {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private AddressRe address;

    @OneToMany(mappedBy = "member")
    private List<OrderRe> orders = new ArrayList<>();

}