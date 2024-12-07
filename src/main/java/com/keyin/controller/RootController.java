package com.keyin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/enter-numbers"; // Redirects to your numbers input page
    }
}