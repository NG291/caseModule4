package com.codegym.casestudymodule4.service;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    public Coupon findById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }

    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public void delete(Long id) {
        couponRepository.deleteById(id);
    }
}

