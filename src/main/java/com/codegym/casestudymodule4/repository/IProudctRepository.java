package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IProudctRepository extends JpaRepository<Product,Long> {
    Iterable<Product> findByNameContainingIgnoreCase(String name);
    Iterable<Product> findTop8ByIsPromotedTrue();
}
