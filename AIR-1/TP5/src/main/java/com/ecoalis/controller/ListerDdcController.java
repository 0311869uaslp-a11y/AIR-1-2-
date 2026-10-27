package com.ecoalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecoalis.service.DemandeCongeServiceMock;

@Controller
public class ListerDdcController extends ParentController {

   @Autowired
   private DemandeCongeServiceMock service;

   @RequestMapping(value = "/listerDdc")
   public ModelAndView dummy() {

      ModelAndView mv = new ModelAndView("listerDdc");
      mv.addObject("listeDemandes", service.findAll());
      return mv;
   }
}
