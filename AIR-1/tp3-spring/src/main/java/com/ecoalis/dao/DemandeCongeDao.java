package com.ecoalis.dao;

import com.ecoalis.model.DemandeConge;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DemandeCongeDao {
    
    private List<DemandeConge> demandes = new ArrayList<>();
    
    public List<DemandeConge> findAll() {
        return new ArrayList<>(demandes);
    }
    
    public void save(DemandeConge demande) {
        demandes.add(demande);
    }
    
    public int count() {
        return demandes.size();
    }
}