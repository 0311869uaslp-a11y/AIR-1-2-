package com.ecoalis;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DemandeConge {
    private Collaborateur collaborateur;
    private Periode periode;

    public DemandeConge() {}

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}