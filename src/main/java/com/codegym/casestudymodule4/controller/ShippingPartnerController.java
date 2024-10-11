package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.model.ShippingPartner;
import com.codegym.casestudymodule4.service.ShippingPartner.IShippingPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ShippingPartnerController {
    @Autowired
    private IShippingPartnerService shippingPartnerService;

    @GetMapping("/shippingPartner/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("shippingPartner/list");
        Iterable<ShippingPartner> shippingPartners = shippingPartnerService.findAll();
        modelAndView.addObject("shippingPartners",shippingPartners);
        return modelAndView;
    }
    @GetMapping("/shippingPartner/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("shippingPartner/create");
        ShippingPartner shippingPartner = new ShippingPartner();
        shippingPartner.setIsLocked(false); // Hoặc true, tùy thuộc vào logic của bạn
        modelAndView.addObject("shippingPartner", shippingPartner);
        return modelAndView;
    }

    @PostMapping("/shippingPartner/save")
    public ModelAndView save(ShippingPartner shippingPartner) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/shippingPartner/list");
        shippingPartnerService.save(shippingPartner);
        return modelAndView;
    }

    @GetMapping("/shippingPartner/{id}/update")
    public ModelAndView formUpdate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("shippingPartner/update");
        Optional<ShippingPartner> shippingPartner = shippingPartnerService.findById(id);
        modelAndView.addObject("shippingPartner", shippingPartner.get());
        return modelAndView;
    }

    @PostMapping("/shippingPartner/update")
    public ModelAndView update(ShippingPartner shippingPartner) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/shippingPartner/list");
        shippingPartnerService.save(shippingPartner);
        return modelAndView;
    }

    @GetMapping("/shippingPartner/{id}/delete")
    public ModelAndView formDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("shippingPartner/delete");
        Optional<ShippingPartner> shippingPartner = shippingPartnerService.findById(id);
        if (shippingPartner.isPresent()) {
            modelAndView.addObject("shippingPartner", shippingPartner.get()); // Lấy đối tượng
        } else {
            modelAndView.addObject("error", "Đối tác vận chuyển không tồn tại.");
        }
        return modelAndView;
    }


    @PostMapping("/shippingPartner/delete")
    public ModelAndView delete(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/shippingPartner/list");
        shippingPartnerService.remove(id);
        return modelAndView;
    }
    @PostMapping("/shippingPartner/{id}/lock")
    public ModelAndView lock(@PathVariable("id") Long id) {
        shippingPartnerService.lockShippingPartner(id);
        return new ModelAndView("redirect:/admin/shippingPartner/list");
    }

    @PostMapping("/shippingPartner/{id}/unlock")
    public ModelAndView unlock(@PathVariable("id") Long id) {
        shippingPartnerService.unlockShippingPartner(id);
        return new ModelAndView("redirect:/admin/shippingPartner/list");
    }

}
