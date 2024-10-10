package com.codegym.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_coupons")
public class OrderCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCouponId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;
    // Getters and setters
}
