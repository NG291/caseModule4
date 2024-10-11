package com.codegym.casestudymodule4.controller.merchantController;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.model.Merchant;
import com.codegym.casestudymodule4.service.CouponService;
import com.codegym.casestudymodule4.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/merchant/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;
    @Autowired
    MerchantService merchantService;

    @GetMapping
    public String getAllCoupons(Model model) {
        List<Coupon> coupons = couponService.findAll();
        model.addAttribute("coupons", coupons);
        return "merchant/coupons/list";
    }

    @GetMapping("/create")
    public String createCouponForm(Model model) {
        List<Merchant> merchants = merchantService.findAll();
        model.addAttribute("merchants", merchants);
        model.addAttribute("coupon", new Coupon());
        return "merchant/coupons/create";
    }

    @PostMapping
    public String createCoupon(@ModelAttribute Coupon coupon) {
        couponService.save(coupon);
        return "redirect:/merchant/coupons";
    }

    @GetMapping("/edit/{id}")
    public String editCouponForm(@PathVariable Long id, Model model) {
        Coupon coupon = couponService.findById(id);
        if (coupon != null) {
            model.addAttribute("coupon", coupon);
            return "merchant/coupons/edit";
        }
        return "redirect:/merchant/coupons";
    }

    @PostMapping("update/{id}")
    public String updateCoupon(@PathVariable Long id, @ModelAttribute Coupon coupon) {
        coupon.setCouponId(id);
        couponService.save(coupon);
        return "redirect:/merchant/coupons";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoupon(@PathVariable Long id) {
        couponService.delete(id);
        return "redirect:/merchant/coupons";
    }
}
