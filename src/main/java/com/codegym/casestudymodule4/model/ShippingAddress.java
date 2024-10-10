package com.codegym.casestudymodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String address;

    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    // Getters and setters
}
