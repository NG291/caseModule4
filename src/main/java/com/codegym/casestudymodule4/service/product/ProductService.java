package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.IProudctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProudctRepository proudctRepository;
    @Override
    public Iterable<Product> findByNameContainingIgnoreCase(String name) {
        return proudctRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Product> findTop8ByIsPromotedTrue() {
        return proudctRepository.findTop8ByIsPromotedTrue();
    }

    @Override
    public Iterable<Product> findAll() {
        return proudctRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return proudctRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return proudctRepository.save(product);
    }

    @Override
    public void remove(Long id) {
      proudctRepository.deleteById(id);
    }
}
