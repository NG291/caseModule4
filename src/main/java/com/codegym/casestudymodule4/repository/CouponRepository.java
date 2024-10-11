package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
