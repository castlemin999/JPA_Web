package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    // 1:1 관계에서는 Access가 더 많은 곳에 FK를 설정해준다
    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL 컬럼 순서대로 숫자가 들어감 (사용X)
    private DeliveryStatus status; // READY, COMP

}
