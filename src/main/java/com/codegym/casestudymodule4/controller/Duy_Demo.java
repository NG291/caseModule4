package com.codegym.casestudymodule4.controller;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class Duy_Demo {

    @GetMapping
    public String hello() {
        return "Hello";
    }

}
