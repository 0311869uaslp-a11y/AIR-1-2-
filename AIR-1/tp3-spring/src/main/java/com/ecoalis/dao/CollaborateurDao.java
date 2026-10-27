package com.ecoalis.dao;

import com.ecoalis.model.Collaborateur;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository  // Anotación ESPECÍFICA para DAOs (igual que @Component pero semántico)
public class CollaborateurDao {
    
    // Simulación de base de datos en memoria
    private List<Collaborateur> collaborateurs = new ArrayList<>();
    
    public CollaborateurDao() {
        // Datos de prueba
        collaborateurs.add(new Collaborateur("Dupont", "Jean", "IT"));
        collaborateurs.add(new Collaborateur("Martin", "Marie", "RH"));
        collaborateurs.add(new Collaborateur("Bernard", "Pierre", "Finance"));
    }
    
    public List<Collaborateur> findAll() {
        return new ArrayList<>(collaborateurs);
    }
    
    public Collaborateur findById(int id) {
        if (id >= 0 && id < collaborateurs.size()) {
            return collaborateurs.get(id);
        }
        return null;
    }
    
    public void save(Collaborateur collaborateur) {
        collaborateurs.add(collaborateur);
    }
    
    public int count() {
        return collaborateurs.size();
    }
}