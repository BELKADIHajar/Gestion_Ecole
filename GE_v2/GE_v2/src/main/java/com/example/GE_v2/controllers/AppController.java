package com.example.GE_v2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("")
    public String viewHomePage(){
        return "professeurs";
    }

    @GetMapping("/about")
    public String viewAboutPage(){
        return "about";
    }
}
