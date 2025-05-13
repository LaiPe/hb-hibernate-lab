package com.exemple;

import com.exemple.model.User;
import com.exemple.service.Service;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Démarrage de l'application");

        User monUser = new User();
        monUser.setNom("Léo");
        monUser.setEmail("leotest@email.com");

        Service<User> monServiceUser = new Service<>(User.class);
        monServiceUser.create(monUser);

        User monUserLu = monServiceUser.read(1L);
        System.out.println(monUserLu.getId() + " " + monUserLu.getNom() + " " + monUserLu.getEmail());

        monUser.setEmail("nouvelemail@email.com");
        monUser.setId(1L);
        monServiceUser.update(monUser);

        monUserLu = monServiceUser.read(1L);
        System.out.println(monUserLu.getId() + " " + monUserLu.getNom() + " " + monUserLu.getEmail());

        monServiceUser.delete(1L);

        monUserLu = monServiceUser.read(1L);
        System.out.println(monUserLu.getId() + " " + monUserLu.getNom() + " " + monUserLu.getEmail());
    }
}
