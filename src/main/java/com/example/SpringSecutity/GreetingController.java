package com.example.SpringSecutity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String publicPage(){
        return "public";
    }
    @GetMapping("/private")
    public String privatePage(){
        return "private";
    }
}
