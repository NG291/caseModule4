package com.codegym.casestudymodule4.model;

import com.codegym.casestudymodule4.model.ENUM.ClaimStatus;
import com.codegym.casestudymodule4.model.ENUM.PayoutStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "payouts")
public class Payout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payoutId;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PayoutStatus status;  // Pending, Confirmed

    @Enumerated(EnumType.STRING)
    @Column(name = "claim_status", nullable = false)
    private ClaimStatus claimStatus;  // Claimed, Unclaimed

    @Column(name = "payout_date", nullable = false)
    private LocalDate payoutDate;

    // Getters and setters
}
