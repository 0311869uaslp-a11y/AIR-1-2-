package com.ecoalis.controller;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.service.DemandeCongeServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/detailDdc") // Mapea: /ddc/detailDdc
public class DetailDdcController {
    
    @Autowired
    private DemandeCongeServiceMock demandeCongeService;
    
    /**
     * Gestiona: /ddc/detailDdc?ddcId=1
     * @RequestParam obtiene parámetro de la URL
     */
    @RequestMapping
    public String detailDemande(
            @RequestParam("ddcId") Long ddcId,
            Model model) {
        
        System.out.println("DetailDdcController: Solicitando detalle ddcId=" + ddcId);
        
        // Obtener demanda del servicio
        DemandeConge demande = demandeCongeService.getDemandeById(ddcId);
        
        if (demande == null) {
            System.out.println("Demanda no encontrada para id: " + ddcId);
            model.addAttribute("error", "Demanda no encontrada");
            return "error";
        }
        
        System.out.println("Demanda encontrada: " + demande);
        
        // Agregar al modelo
        model.addAttribute("demande", demande);
        
        return "detailDdc"; // Vista: /WEB-INF/views/detailDdc.jsp
    }
}