package com.ecoalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.security.Principal;

@Controller
@RequestMapping("/ddc")  // ¡AÑADE ESTA LÍNEA!
public class HomeController {
    
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "home";
    }
    
    @GetMapping("/")
    public String index() {
        return "redirect:/ddc/home";  // Cambia a /ddc/home
    }
    
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}