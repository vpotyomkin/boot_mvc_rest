package com.jm.boot_mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class startPage {
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
}
