package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.IProudctRepository;
import com.codegym.casestudymodule4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class ProductController1 {
    @Autowired
    private IProductService productService;
    @GetMapping("/search")
    public ModelAndView searchNameProduct (@RequestParam(value = "name", required = false, defaultValue = "") String name){
        Iterable<Product> products = productService.findByNameContainingIgnoreCase(name);
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @GetMapping("/promoted")
    public ModelAndView listPromotedProducts() {
        ModelAndView modelAndView = new ModelAndView("product/list1");
        Iterable<Product> promotedProducts = productService.findTop8ByIsPromotedTrue();
        modelAndView.addObject("promotedProducts", promotedProducts);
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public ModelAndView showViewProduct(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/product/view");
        Optional<Product> product = productService.findById(id);
        modelAndView.addObject("product", product.get());
        return  modelAndView;
    }
}
