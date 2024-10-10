package com.codegym.casestudymodule4.model;

import com.codegym.casestudymodule4.model.ENUM.AccountStatus;
import com.codegym.casestudymodule4.model.ENUM.ROLE;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;  // Encrypted password

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ROLE role;  // USER, ADMIN, MERCHANT
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

}
