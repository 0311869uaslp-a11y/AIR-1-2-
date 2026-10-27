package com.ecoalis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.model.TypeDdc;
import com.ecoalis.service.DemandeCongeServiceMock;
import com.ecoalis.validator.DemandeCongeValidator;

@Controller
public class CreerDdcController extends ParentController {

   @Autowired
   private DemandeCongeServiceMock service;

   @ModelAttribute("typeDdc")
   public TypeDdc[] populateTypeDdc() {
      return TypeDdc.values();
   }

   @ModelAttribute("demandeConge")
   public DemandeConge getDdc() {
      return new DemandeConge();
   }

   @RequestMapping(value = "/creerDdc/form", method = RequestMethod.GET)
   public String setupForm(Model model) {
      model.addAttribute("now", new SimpleDateFormat("dd/mm/yyyy").format(new Date()));
      model.addAttribute("demandeConge", buildDefaultDemandeConge());
      return "creerDdc";
   }

   @RequestMapping(value = "/creerDdc/form", method = RequestMethod.POST)
   public String processSubmit(@Valid @ModelAttribute DemandeConge dc, BindingResult result) {

      new DemandeCongeValidator().validate(dc, result);

      if (result.hasErrors()) {
         return "creerDdc";
      }

      service.save(dc); 

      return "redirect:/ddc/listerDdc";
   }

   private DemandeConge buildDefaultDemandeConge() {
      DemandeConge dc = new DemandeConge();
      dc.setNumero(Double.valueOf(Math.random() * 1000).intValue());
      return dc;
   }
}
