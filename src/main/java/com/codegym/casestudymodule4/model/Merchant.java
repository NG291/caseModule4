package com.codegym.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "merchants")
public class  Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_partner", nullable = false)
    private Boolean isPartner;

    // Getters and setters
}
