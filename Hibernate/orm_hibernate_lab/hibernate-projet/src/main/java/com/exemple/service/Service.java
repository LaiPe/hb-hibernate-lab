package com.exemple.service;

import com.exemple.DBAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Map;

public abstract class Service<A> {
    private final Class<A> modelType;
    private final String modelTypeName;
    protected final SessionFactory sessionFactory;

    public Service(Class<A> modelType) {
        this.modelType = modelType;
        this.modelTypeName = modelType.getName().substring(modelType.getName().lastIndexOf('.') + 1);;
        this.sessionFactory = DBAccess.getInstance().getSessionFactory();
    }

    public void create(A entity){
        System.out.println("==========================================");
        System.out.println("          CRUD operation CREATE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("CRUD ERROR : Impossible to CREATE entity " + modelTypeName);
        }
        System.out.println("\n");
    }

    public A read(Long id){
        System.out.println("==========================================");
        System.out.println("           CRUD operation READ");
        System.out.println("==========================================");

        A entity = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(modelType, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("CRUD ERROR : Impossible to READ entity " + modelTypeName + " of id " + id);
        }
        System.out.println("\n");
        return entity;
    }

    public void update(A entity){
        System.out.println("==========================================");
        System.out.println("          CRUD operation UPDATE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("CRUD ERROR : Impossible to UPDATE entity " + modelTypeName);
        }
        System.out.println("\n");
    }

    public void delete(Long id){
        System.out.println("==========================================");
        System.out.println("          CRUD operation DELETE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("CRUD ERROR : Impossible to DELETE entity " + modelTypeName + " of id " + id);
        }
        System.out.println("\n");
    }

    protected void print(Map<String,String> attributes){
        System.out.println("==========================================");
        System.out.println("              PRINT operation");
        System.out.println("==========================================");

        if (!attributes.isEmpty()) {
            System.out.println(modelTypeName.toUpperCase() + " entity");
            System.out.println("------------------------------------------");
            for (Map.Entry<String,String> attr : attributes.entrySet()) {
                System.out.println(attr.getKey() + " : " + attr.getValue());
            }
        } else {
            System.err.println("ERROR : Impossible to PRINT null entity " + modelTypeName);
        }
        System.out.println("\n");
    };
}
