package com.ecoalis.service;

import com.ecoalis.model.Collaborateur;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CollaborateurRepository {
    
    private Map<Long, Collaborateur> collaborateurs = new HashMap<>();
    
    public CollaborateurRepository() {
        // Constructor con 4 parámetros
        collaborateurs.put(1L, new Collaborateur(1L, "Dupont", "Jean", "IT"));
        collaborateurs.put(2L, new Collaborateur(2L, "Martin", "Marie", "RH"));
        collaborateurs.put(3L, new Collaborateur(3L, "Bernard", "Pierre", "Finance"));
        collaborateurs.put(4L, new Collaborateur(4L, "Garcia", "Ana", "Marketing"));
    }
    
    public List<Collaborateur> findAll() {
        return new ArrayList<>(collaborateurs.values());
    }
    
    public Collaborateur findById(Long id) {
        return collaborateurs.get(id);
    }
}