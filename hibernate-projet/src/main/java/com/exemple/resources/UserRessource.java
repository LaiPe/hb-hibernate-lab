package com.exemple.resources;

import com.exemple.dao.UserDAO;
import com.exemple.dto.UserDTO;
import com.exemple.models.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRessource {
    private final UserDAO dao = new UserDAO(false);

    @GET
    public List<UserDTO> getAll() {
        List<User> daoUsers = dao.readAll();
        List<UserDTO> dtoUsers = new ArrayList<>();
        for (User user : daoUsers) {
            UserDTO dto = new UserDTO();
            dto.setNom(user.getNom());
            dto.setEmail(user.getEmail());
            dtoUsers.add(dto);
        }
        return dtoUsers;
    }

    @GET
    @Path("/{id}")
    public User getById(@PathParam("id") Long id) {
        return dao.read(id);
    }

    @POST
    public void create(User user) {
        dao.create(user);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, User user) {
        user.setId(id);
        dao.create(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        dao.delete(id);
    }
}