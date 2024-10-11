package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.GenerateService;

import java.util.Optional;

public interface IProductService extends GenerateService<Product> {
    Iterable<Product> findByNameContainingIgnoreCase(String name);
    Iterable<Product> findTop8ByIsPromotedTrue();
}
