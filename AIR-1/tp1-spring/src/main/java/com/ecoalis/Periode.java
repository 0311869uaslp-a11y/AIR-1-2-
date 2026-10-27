package com.ecoalis;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Periode {
    private String dateDebut;
    private int nbJours;

    public Periode() {}

    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    public void setNbJours(int nbJours) { this.nbJours = nbJours; }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}