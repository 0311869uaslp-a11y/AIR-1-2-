package com.ecoalis.validator;

import com.ecoalis.model.DemandeConge;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.Date;

@Component
public class DemandeCongeValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return DemandeConge.class.equals(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        DemandeConge demande = (DemandeConge) target;
        
        // 1. Validación de champs obligatoires avec ValidationUtils
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commentaire", 
            "commentaire.required", "Le commentaire est obligatoire");
        
        // 2. Validation personnalisée: date ne peut être dans le passé
        if (demande.getDateDebut() != null) {
            Date aujourdHui = new Date();
            if (demande.getDateDebut().before(aujourdHui)) {
                errors.rejectValue("dateDebut", "dateDebut.past",
                    "La date de début ne peut être dans le passé");
            }
        }
        
        // 3. Validation: nbJours > 0
        if (demande.getNbJours() <= 0) {
            errors.rejectValue("nbJours", "nbJours.positive",
                "Le nombre de jours doit être positif");
        }
        
        // 4. Validation: commentaire longueur
        if (demande.getCommentaire() != null && demande.getCommentaire().length() < 10) {
            errors.rejectValue("commentaire", "commentaire.minlength",
                "Le commentaire doit faire au moins 10 caractères");
        }
        
        // 5. Validation: typeDdc requis
        if (demande.getTypeDdc() == null) {
            errors.rejectValue("typeDdc", "typeDdc.required",
                "Le type de congé est obligatoire");
        }
    }
}