package com.jpabook.jpashop.domainRe;

import com.jpabook.jpashop.domain.Delivery;
import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderRe {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberRe member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemRe> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private DeliveryRe delivery;

    private LocalDateTime orderDate;

    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //==연관관계 메서드==
    public void setMember(MemberRe member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItems(OrderItemRe orderItemRe) {
        this.orderItems.add(orderItemRe);
        orderItemRe.setOrder(this);
    }

    public void setDelivery(DeliveryRe delivery) {
        this.delivery = delivery;
        delivery.setOrderRe(this);
    }



}
