package com.exemple.dao;

import com.exemple.models.Annonce;

public class AnnonceDAO extends GenericDAOImpl<Annonce,Long> implements GenericDAO<Annonce,Long> {
    public AnnonceDAO(boolean verbose) {
        super(Annonce.class, verbose);
    }
}
