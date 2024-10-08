package com.example.SpringSecutity;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IModel;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String publicPage(){
        return "public";
    }
    @GetMapping("/private")
    public String privatePage(Model model, Authentication authentication){
        model.addAttribute("name", getName(authentication));
        return "private";
    }
    private static String getName(Authentication authentication) {
        if (authentication.getPrincipal() instanceof OidcUser oidcUser) {
            return oidcUser.getEmail();
        }
        return authentication.getName();
    }
}
