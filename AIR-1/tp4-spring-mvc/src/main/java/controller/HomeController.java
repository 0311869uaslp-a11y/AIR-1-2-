package com.ecoalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    /**
     * Gestiona la URL: http://localhost:8080/tp4-spring-mvc/ddc/home
     * Según web.xml: /ddc/* va al DispatcherServlet
     */
    @RequestMapping("/home")
    public String home() {
        System.out.println("HomeController: Acceso a /ddc/home");
        return "home"; // Nombre lógico de vista → /WEB-INF/views/home.jsp
    }
}