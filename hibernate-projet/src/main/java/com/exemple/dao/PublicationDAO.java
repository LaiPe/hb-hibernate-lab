package com.exemple.dao;

import com.exemple.models.Publication;

import java.util.List;

public class PublicationDAO {
    private GenericDAO<Publication,Long> dao;

    public PublicationDAO(boolean verbose) {
        dao = new GenericDAOImpl<>(Publication.class, verbose) {
            @Override
            public List<Publication> readAll() {
                return super.readAll();
            }

            @Override
            public Publication read(Long id) {
                return super.read(id);
            }
        };
    }

    public List<Publication> readAll() {
        return dao.readAll();
    }

    public Publication read(Long id) {
        return dao.read(id);
    }
}
