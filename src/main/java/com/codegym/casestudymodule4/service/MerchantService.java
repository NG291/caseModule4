package com.codegym.casestudymodule4.service;

import com.codegym.casestudymodule4.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    @Autowired MerchantRepository merchantRepository;

    public List<Merchant> findAll() {
        return (List<Merchant>) merchantRepository.findAll();
    }
}
