package com.codegym.casestudymodule4.model;

import com.codegym.casestudymodule4.model.ENUM.CartStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CartStatus status;  // Active, Inactive

    // Getters and setters
}
