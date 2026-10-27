package com.ecoalis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.service.DemandeCongeServiceMock;

@Controller
public class DetailDdcController extends ParentController {

   private DemandeCongeServiceMock demandeCongeService = new DemandeCongeServiceMock();

   @RequestMapping(value = "/detailDdc")
   public ModelAndView detail(@RequestParam int ddcId) {

      DemandeConge demandeConge = demandeCongeService.getDemandeConge(ddcId);

      Map<String, Object> model = new HashMap<String, Object>();

      model.put("demandeConge", demandeConge);

      return new ModelAndView("detailDdc", model);
   }
}
