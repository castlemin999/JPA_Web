package com.jpabook.jpashop.domainRe;

import com.jpabook.jpashop.domain.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DeliveryRe {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private OrderRe orderRe;

    @Embedded
    private AddressRe addressRe;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
