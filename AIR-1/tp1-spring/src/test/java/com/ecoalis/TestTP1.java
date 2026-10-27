package com.ecoalis;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TestTP1 {
    public static void main(String[] args) {
        // Cargar el contenedor Spring con BeanFactory
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/applicationContext.xml"));

        // Recuperar bean por setter
        DemandeConge demande1 = (DemandeConge) factory.getBean("demandeConge");
        System.out.println("DemandeConge (setter): " + demande1);

        // Recuperar segunda instancia para verificar scope singleton
        DemandeConge demande2 = (DemandeConge) factory.getBean("demandeConge");
        System.out.println("DemandeConge (setter) 2: " + demande2);
        System.out.println("¿Misma instancia? " + (demande1 == demande2));

        // Recuperar bean por constructor
        DemandeCongeSansModificateurs demandeSans = (DemandeCongeSansModificateurs) factory.getBean("demandeCongeSansMod");
        System.out.println("DemandeCongeSansModificateurs (constructor): " + demandeSans);
    }
    
    
}