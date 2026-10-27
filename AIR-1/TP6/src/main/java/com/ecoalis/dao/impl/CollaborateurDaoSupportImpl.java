package com.ecoalis.dao.impl;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.ecoalis.dao.CollaborateurDaoSupport;
import com.ecoalis.model.Collaborateur;

public class CollaborateurDaoSupportImpl extends JpaDaoSupport implements CollaborateurDaoSupport {

   public Collaborateur find(long id) {
      return getJpaTemplate().find(Collaborateur.class, id);
   }

}