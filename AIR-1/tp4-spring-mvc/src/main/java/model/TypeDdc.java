package com.ecoalis.model;

public enum TypeDdc {
    CONGE_PAYE("Congé payé"),
    RTT("RTT"),
    CONGE_SANS_SOLDE("Congé sans solde"),
    CONGE_MATERNITE("Congé maternité"),
    CONGE_PATERNITE("Congé paternité");
    
    private final String libelle;
    
    TypeDdc(String libelle) {
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }
}