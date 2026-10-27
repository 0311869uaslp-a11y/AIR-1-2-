package com.ecoalis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTP2 {
    public static void main(String[] args) {
        System.out.println("=== TP2 - INJECTION AUTOMATIQUE ===\n");
        
        // 1. Cargar contexto Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Probando autowiring byType
        System.out.println("1. AUTOWIRING BYTYPE:");
        DemandeConge demandeByType = (DemandeConge) context.getBean("demandeConge");
        System.out.println("   DemandeConge: " + demandeByType);
        System.out.println("   ¿C inyectado? " + (demandeByType.getC() != null));
        System.out.println("   ¿P inyectado? " + (demandeByType.getP() != null));
        
        // 3. Probando autowiring byName
        System.out.println("\n2. AUTOWIRING BYNAME:");
        DemandeConge demandeByName = (DemandeConge) context.getBean("demandeCongeByName");
        System.out.println("   DemandeConge: " + demandeByName);
        System.out.println("   ¿C inyectado? " + (demandeByName.getC() != null));
        System.out.println("   ¿P inyectado? " + (demandeByName.getP() != null));
        
        // 4. Probando autowiring constructor
        System.out.println("\n3. AUTOWIRING CONSTRUCTOR:");
        DemandeCongeSansModificateurs demandeConstructor = 
            (DemandeCongeSansModificateurs) context.getBean("demandeCongeSansMod");
        System.out.println("   DemandeCongeSansMod: " + demandeConstructor);
        System.out.println("   ¿Collaborateur inyectado? " + 
            (demandeConstructor.getCollaborateur() != null));
        System.out.println("   ¿Periode inyectado? " + 
            (demandeConstructor.getPeriode() != null));
        
        // 5. Probando @Autowired
        System.out.println("\n4. @AUTOWIRED:");
        DemandeConge demandeAnnotation = (DemandeConge) context.getBean("demandeAnnotation");
        System.out.println("   DemandeConge (@Autowired): " + demandeAnnotation);
        System.out.println("   ¿Collaborateur inyectado? " + 
            (demandeAnnotation.getCollaborateur() != null));
        System.out.println("   ¿Periode inyectado? " + 
            (demandeAnnotation.getPeriode() != null));
        
        // 6. Verificar que son los mismos beans
        System.out.println("\n5. VERIFICACIÓN DE BEANS:");
        System.out.println("   ¿Mismo Collaborateur en todos? " + 
            (demandeByType.getC() == demandeByName.getC()));
        System.out.println("   ¿Mismo Periode en todos? " + 
            (demandeByType.getP() == demandeConstructor.getPeriode()));
        
        // Cerrar contexto
        ((ClassPathXmlApplicationContext) context).close();
    }
}