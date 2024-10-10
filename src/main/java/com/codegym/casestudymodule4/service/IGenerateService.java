package com.codegym.casestudymodule4.service;

import java.util.Optional;

public interface IGenerateService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void deleteById(Long id);
}
