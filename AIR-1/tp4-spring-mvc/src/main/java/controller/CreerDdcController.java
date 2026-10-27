package com.ecoalis.controller;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.model.Collaborateur;
import com.ecoalis.model.TypeDdc;
import com.ecoalis.service.DemandeCongeServiceMock2;
import com.ecoalis.validator.DemandeCongeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/nouveauDdc")  // RUTA NUEVA Y ÚNICA
@SessionAttributes("demandeConge")
public class CreerDdcController {
    
    @Autowired
    private DemandeCongeServiceMock2 demandeCongeService;
    
    @Autowired
    private DemandeCongeValidator demandeCongeValidator;
    
    @PostConstruct
    public void init() {
        System.out.println("======================================");
        System.out.println("CONTROLADOR CreerDdcController CARGADO");
        System.out.println("Mapeado a: /nouveauDdc");
        System.out.println("======================================");
    }
    
    @ModelAttribute("typeDdc")
    public TypeDdc[] populateTypeDdc() {
        return TypeDdc.values();
    }
    
    @ModelAttribute("demandeConge")
    public DemandeConge getDdc() {
        System.out.println("Création d'une nouvelle DemandeConge vide");
        return new DemandeConge();
    }
    
    /**
     * GET /nouveauDdc/form - Muestra el formulario
     */
    @GetMapping("/form")
    public String setupForm(Model model) {
        System.out.println("=== GET /nouveauDdc/form ===");
        System.out.println("✅ ACCEDIENDO AL NUEVO FORMULARIO");
        
        String now = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        model.addAttribute("now", now);
        model.addAttribute("collaborateurs", demandeCongeService.getAllCollaborateurs());
        
        return "creerDdc";
    }
    
    /**
     * POST /nouveauDdc/submit - Procesa el formulario
     */
    @PostMapping("/submit")
    public String processSubmit(HttpServletRequest request, Model model) {
        System.out.println("=== POST /nouveauDdc/submit ===");
        System.out.println("✅ FORMULARIO ENVIADO AL NUEVO CONTROLADOR");
        System.out.println("URL completa: " + request.getRequestURL());
        
        // 1. Mostrar TODOS los parámetros
        Map<String, String[]> params = request.getParameterMap();
        System.out.println("📋 Número de parámetros: " + params.size());
        
        if (params.isEmpty()) {
            System.out.println("⚠️  ¡NO SE RECIBIERON PARÁMETROS!");
        } else {
            System.out.println("📋 Parámetros recibidos:");
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                System.out.println("  🔹 " + entry.getKey() + " = " + String.join(", ", entry.getValue()));
            }
        }
        
        // 2. Obtener parámetros individuales
        String collaborateurId = request.getParameter("collaborateurId");
        String dateDebutStr = request.getParameter("dateDebut");
        String nbJoursStr = request.getParameter("nbJours");
        String typeDdcStr = request.getParameter("typeDdc");
        String commentaire = request.getParameter("commentaire");
        
        System.out.println("\n📊 Valores individuales:");
        System.out.println("  🔸 collaborateurId: " + collaborateurId);
        System.out.println("  🔸 dateDebut: " + dateDebutStr);
        System.out.println("  🔸 nbJours: " + nbJoursStr);
        System.out.println("  🔸 typeDdc: " + typeDdcStr);
        System.out.println("  🔸 commentaire: " + commentaire);
        
        // 3. Procesar collaborateur
        if (collaborateurId != null && !collaborateurId.isEmpty()) {
            try {
                Long id = Long.parseLong(collaborateurId);
                Collaborateur collaborateur = demandeCongeService.getAllCollaborateurs().stream()
                        .filter(c -> c.getId().equals(id))
                        .findFirst()
                        .orElse(null);
                
                if (collaborateur != null) {
                    System.out.println("✅ Collaborateur trouvé: " + collaborateur);
                    
                    // Crear DemandeConge manualmente
                    DemandeConge demande = new DemandeConge();
                    demande.setCollaborateur(collaborateur);
                    
                    // Procesar fecha
                    if (dateDebutStr != null && !dateDebutStr.isEmpty()) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date dateDebut = sdf.parse(dateDebutStr);
                            demande.setDateDebut(dateDebut);
                            System.out.println("✅ Date parsée: " + dateDebut);
                        } catch (ParseException e) {
                            System.out.println("❌ Error parsing date: " + e.getMessage());
                        }
                    }
                    
                    // Procesar otros campos
                    if (nbJoursStr != null && !nbJoursStr.isEmpty()) {
                        try {
                            demande.setNbJours(Integer.parseInt(nbJoursStr));
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Error parsing nbJours");
                        }
                    }
                    
                    if (typeDdcStr != null && !typeDdcStr.isEmpty()) {
                        try {
                            demande.setTypeDdc(TypeDdc.valueOf(typeDdcStr));
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ TypeDdc invalide: " + typeDdcStr);
                        }
                    }
                    
                    demande.setCommentaire(commentaire);
                    
                    // Guardar
                    demandeCongeService.creerDemande(demande);
                    System.out.println("✅ Demande créée avec ID: " + demande.getId());
                    
                    model.addAttribute("success", "Demande créée avec succès! ID: " + demande.getId());
                    
                } else {
                    System.out.println("❌ Collaborateur non trouvé pour ID: " + collaborateurId);
                    model.addAttribute("error", "Collaborateur non trouvé");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ ID de collaborateur invalide: " + collaborateurId);
                model.addAttribute("error", "ID de collaborateur invalide");
            }
        } else {
            System.out.println("❌ Aucun collaborateurId reçu");
            model.addAttribute("error", "Veuillez sélectionner un collaborateur");
        }
        
        // 4. Recargar datos para la vista
        model.addAttribute("collaborateurs", demandeCongeService.getAllCollaborateurs());
        model.addAttribute("now", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        
        return "creerDdc";
    }
    
    /**
     * GET /nouveauDdc/test - Formulario con datos de prueba
     */
    @GetMapping("/test")
    public String setupTestForm(@ModelAttribute("demandeConge") DemandeConge demande, Model model) {
        System.out.println("=== GET /nouveauDdc/test ===");
        
        // Simuler des données de test
        demande.setNbJours(5);
        demande.setCommentaire("Demande de test automatique");
        
        String now = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        model.addAttribute("now", now);
        model.addAttribute("collaborateurs", demandeCongeService.getAllCollaborateurs());
        
        return "creerDdc";
    }
    
    /**
     * GET /nouveauDdc/success - Página de éxito
     */
    @GetMapping("/success")
    public String successPage(Model model) {
        System.out.println("=== GET /nouveauDdc/success ===");
        return "success";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("🔧 InitBinder ejecutado");
        
        // Editor para Collaborateur
        binder.registerCustomEditor(Collaborateur.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                System.out.println("🔧 Editor: Conversion de '" + text + "' en Collaborateur");
                if (text != null && !text.isEmpty()) {
                    try {
                        Long id = Long.parseLong(text);
                        Collaborateur collaborateur = demandeCongeService.getAllCollaborateurs().stream()
                                .filter(c -> c.getId().equals(id))
                                .findFirst()
                                .orElse(null);
                        System.out.println("🔧 Editor: Collaborateur trouvé: " + collaborateur);
                        setValue(collaborateur);
                    } catch (NumberFormatException e) {
                        System.out.println("🔧 Editor: Error parsing ID: " + e.getMessage());
                        setValue(null);
                    }
                } else {
                    setValue(null);
                }
            }
            
            @Override
            public String getAsText() {
                Collaborateur collaborateur = (Collaborateur) getValue();
                return collaborateur != null ? collaborateur.getId().toString() : "";
            }
        });
        
        // Editor para fechas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}