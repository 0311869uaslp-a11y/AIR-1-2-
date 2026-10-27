package com.ecoalis;

import com.ecoalis.model.Collaborateur;
import com.ecoalis.model.DemandeConge;
import com.ecoalis.model.Periode;
import com.ecoalis.service.CollaborateurService;
import com.ecoalis.service.DemandeCongeService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTP3 {
    public static void main(String[] args) {
        System.out.println("=== TP3 - DÉTECTION AUTOMATIQUE DES COMPOSANTS ===\n");
        
        // 1. Cargar contexto (Spring detectará automáticamente los componentes)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("1. SPRING HA DETECTADO AUTOMÁTICAMENTE:");
        System.out.println("   - Componentes anotados con @Component, @Service, @Repository");
        System.out.println("   - En el paquete: com.ecoalis y subpaquetes");
        
        // 2. Obtener beans (Spring ya los creó automáticamente)
        System.out.println("\n2. OBTENIENDO BEANS AUTOMÁTICAMENTE CREADOS:");
        
        // Servicio de colaboradores (inyectado automáticamente con DAO)
        CollaborateurService collaborateurService = 
            context.getBean("collaborateurService", CollaborateurService.class);
        System.out.println("   ✓ CollaborateurService obtenido");
        System.out.println("   Número de collaborateurs: " + collaborateurService.getNombreCollaborateurs());
        
        // Servicio de demandas (inyectado automáticamente con DAO)
        DemandeCongeService demandeCongeService = 
            context.getBean("demandeCongeService", DemandeCongeService.class);
        System.out.println("   ✓ DemandeCongeService obtenido");
        
        // 3. Demostrar que Spring inyectó las dependencias automáticamente
        System.out.println("\n3. INYECCIÓN AUTOMÁTICA DE DEPENDENCIAS:");
        
        // Obtener un colaborador del DAO (a través del servicio)
        Collaborateur collab = collaborateurService.getCollaborateurById(0);
        System.out.println("   Collaborateur desde DAO: " + 
            (collab != null ? collab.getNom() + " " + collab.getPrenom() : "null"));
        
        // 4. Crear una nueva demanda
        System.out.println("\n4. CREANDO NUEVA DEMANDA DE CONGÉ:");
        
        // Obtener componentes del contexto
        Collaborateur nouveauCollab = context.getBean(Collaborateur.class);
        Periode nouvellePeriode = context.getBean(Periode.class);
        
        // Modificar valores (en una app real vendrían de un formulario)
        nouveauCollab.setNom("Garcia");
        nouveauCollab.setPrenom("Ana");
        nouveauCollab.setDepartement("Marketing");
        
        nouvellePeriode.setDateDebut("2025-03-15");
        nouvellePeriode.setNbJours(7);
        
        // Crear demanda
        DemandeConge nouvelleDemande = new DemandeConge(nouveauCollab, nouvellePeriode);
        
        // Usar el servicio (que está inyectado con el DAO)
        demandeCongeService.creerDemande(nouvelleDemande);
        
        // 5. Mostrar todos los collaborateurs
        System.out.println("\n5. LISTE DES COLLABORATEURS (depuis le service):");
        collaborateurService.getAllCollaborateurs().forEach(c -> 
            System.out.println("   - " + c.getNom() + " " + c.getPrenom() + " (" + c.getDepartement() + ")")
        );
        
        // 6. Verificar nombres de beans
        System.out.println("\n6. NOMS DES BEANS DÉTECTÉS:");
        String[] beanNames = context.getBeanDefinitionNames();
        int componentCount = 0;
        for (String beanName : beanNames) {
            if (!beanName.contains("org.springframework")) {
                System.out.println("   - " + beanName);
                componentCount++;
            }
        }
        System.out.println("   Total beans détectés: " + componentCount);
        
        // 7. Demostrar diferentes formas de obtener beans
        System.out.println("\n7. DIFFÉRENTES FAÇONS D'OBTENIR UN BEAN:");
        
        // Por tipo
        Collaborateur c1 = context.getBean(Collaborateur.class);
        System.out.println("   a) Par type: Collaborateur.class -> " + c1.getNom());
        
        // Por nombre (Spring convierte: CollaborateurService -> "collaborateurService")
        CollaborateurService s1 = (CollaborateurService) context.getBean("collaborateurService");
        System.out.println("   b) Par nom: 'collaborateurService' -> " + s1.getClass().getSimpleName());
        
        // Por nombre y tipo
        DemandeCongeService s2 = context.getBean("demandeCongeService", DemandeCongeService.class);
        System.out.println("   c) Par nom et type: -> " + s2.getClass().getSimpleName());
        
        // Cerrar contexto
        ((ClassPathXmlApplicationContext) context).close();
        
        System.out.println("\n=== TP3 TERMINÉ AVEC SUCCÈS ===");
    }
}