package com.ecoalis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collaborateur
{
    @Id
    private long id;
    private String prenom;
    private String nom;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String firstName)
    {
        this.prenom = firstName;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String lastName)
    {
        this.nom = lastName;
    }
}