package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
