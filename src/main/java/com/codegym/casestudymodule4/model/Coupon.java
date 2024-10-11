package com.codegym.casestudymodule4.model;

import com.codegym.casestudymodule4.model.ENUM.CouponStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "discount_value", nullable = false)
    private Double discountValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CouponStatus status;  // Active, Expired

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    // Getters and setters
}
