package com.codegym.casestudymodule4.service.coupon;

import com.codegym.casestudymodule4.model.Coupon;

import java.util.List;

public interface ICouponService {
    List<Coupon> findByPro(Long foodId);
}

