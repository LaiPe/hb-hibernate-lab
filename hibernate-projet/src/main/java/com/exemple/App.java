package com.exemple;

import com.exemple.dao.PublicationDAO;
import com.exemple.models.Annonce;
import com.exemple.models.Article;
import com.exemple.models.Publication;
import com.exemple.models.User;
import com.exemple.dao.ArticleDAO;
import com.exemple.dao.UserDAO;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("==========================================");
        System.out.println("       Démarrage de l'application");
        System.out.println("==========================================");
        System.out.println("\n");


        UserDAO userDAO = new UserDAO(true);
        ArticleDAO articleDAO = new ArticleDAO(true);
        PublicationDAO publicationDAO = new PublicationDAO(true);

        ResourceConfig config = new ApiApplication();
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(servlet, "/*");
        server.start();
        server.join();
    }
}
