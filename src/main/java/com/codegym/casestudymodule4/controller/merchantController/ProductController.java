package com.codegym.casestudymodule4.controller.merchantController;

import com.codegym.casestudymodule4.model.Merchant;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.MerchantService;
import com.codegym.casestudymodule4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/merchant/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "organic-1.0.0/index";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        List<Merchant> merchants = merchantService.findAll();
        model.addAttribute("merchants", merchants);
        model.addAttribute("product", new Product());
        return "/merchant/products/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/merchant/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "merchant/products/edit";
        }
        return "redirect:/merchant/products"; // Redirect if not found
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setProductId(id);
        productService.save(product);
        return "redirect:/merchant/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/merchant/products";
    }
}

