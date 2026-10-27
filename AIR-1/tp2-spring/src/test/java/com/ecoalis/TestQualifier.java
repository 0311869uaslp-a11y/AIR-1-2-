package com.ecoalis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQualifier {
    public static void main(String[] args) {
        System.out.println("=== TP2 - RESOLVIENDO AMBIGÜEDAD CON @QUALIFIER ===\n");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-qualifier.xml");
        
        // SOLO probar los que SÍ tienen @Qualifier
        System.out.println("1. CON @QUALIFIER(\"principal\"):");
        DemandeCongeQualifierPrincipal demandePrincipal = 
            (DemandeCongeQualifierPrincipal) context.getBean("demandePrincipal");
        System.out.println("   " + demandePrincipal);
        
        System.out.println("\n2. CON @QUALIFIER(\"secundario\"):");
        DemandeCongeQualifierSecundario demandeSecundario = 
            (DemandeCongeQualifierSecundario) context.getBean("demandeSecundario");
        System.out.println("   " + demandeSecundario);
        
        // ELIMINAR la parte que prueba sin @Qualifier
        // O comentarla:
        /*
        System.out.println("\n3. SIN @QUALIFIER (ambigüedad):");
        try {
            DemandeCongeSimple demandeSans = 
                (DemandeCongeSimple) context.getBean("demandeSansQualifier");
            System.out.println("   " + demandeSans);
        } catch (Exception e) {
            System.out.println("   ERROR ESPERADO: " + e.getClass().getSimpleName());
        }
        */
        
        System.out.println("\n4. VERIFICACIÓN:");
        System.out.println("   ¿Mismo objeto Collaborateur en ambos? " + 
            (demandePrincipal.getCollaborateur() == demandeSecundario.getCollaborateur()));
        
        context.close();
    }
}