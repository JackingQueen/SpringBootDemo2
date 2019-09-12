package com.example.demo2.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SixThymeleafController {
    @GetMapping("/six")
    public String indexPage(Model model) {
        return "index6";
    }
}
