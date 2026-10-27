package com.ecoalis.controller;

import com.ecoalis.service.DemandeCongeServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ddc")
public class DirectionController {

    @Autowired
    private DemandeCongeServiceMock demandeCongeService;

    @GetMapping("/direction")
    public ModelAndView getDirectionPage() {
        ModelAndView modelAndView = new ModelAndView("direction");
        modelAndView.addObject("demandes", demandeCongeService.findAll());
        return modelAndView;
    }
}