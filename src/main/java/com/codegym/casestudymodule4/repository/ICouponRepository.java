package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICouponRepository extends JpaRepository<Coupon,Long> {
}
