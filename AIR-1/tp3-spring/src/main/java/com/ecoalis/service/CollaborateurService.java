package com.ecoalis.service;

import com.ecoalis.model.Collaborateur;
import com.ecoalis.dao.CollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollaborateurService {
    
    @Autowired
    private CollaborateurDao collaborateurDao;
    
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurDao.findAll();
    }
    
    public Collaborateur getCollaborateurById(int id) {
        return collaborateurDao.findById(id);
    }
    
    public int getNombreCollaborateurs() {
        return collaborateurDao.count();
    }
    
    public void ajouterCollaborateur(Collaborateur collaborateur) {
        collaborateurDao.save(collaborateur);
        System.out.println("Service: Collaborateur ajouté: " + collaborateur.getNom());
    }
}