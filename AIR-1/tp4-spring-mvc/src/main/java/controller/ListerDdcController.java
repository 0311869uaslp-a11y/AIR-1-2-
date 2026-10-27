package com.ecoalis.controller;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.service.DemandeCongeServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/listerDdc") // Mapea: /ddc/listerDdc
public class ListerDdcController {
    
    @Autowired
    private DemandeCongeServiceMock demandeCongeService;
    
    @RequestMapping // Mapea GET /ddc/listerDdc
    public String listerDemandes(Model model) {
        System.out.println("ListerDdcController: Listando demandas");
        
        List<DemandeConge> demandes = demandeCongeService.getAllDemandes();
        System.out.println("Número de demandas: " + demandes.size());
        
        // Agrega datos al modelo para la vista
        model.addAttribute("demandes", demandes);
        model.addAttribute("total", demandes.size());
        
        return "listeDdc"; // Vista: /WEB-INF/views/listeDdc.jsp
    }
}