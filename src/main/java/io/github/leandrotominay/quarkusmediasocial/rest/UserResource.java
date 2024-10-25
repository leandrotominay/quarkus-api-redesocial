package io.github.leandrotominay.quarkusmediasocial.rest;

import io.github.leandrotominay.domain.model.User;
import io.github.leandrotominay.quarkusmediasocial.rest.dto.CreateUserRequest;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    public Response createUser( CreateUserRequest userRequest){
        User user = new User();

        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        user.persist(); // Salvar no banco

        return Response.ok(user).build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<PanacheEntityBase> query = User.findAll();
        return Response.ok(query.list()).build();
    }

    @Transactional
    @DELETE
    @Path("{id}")
    // /users/id

    public Response deleteUser( @PathParam("id") Integer id){
        User user = User.findById(id);

        if(user != null){
            user.delete();
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Transactional // Sempre que for atualizar entidade no banco utilizar o metodo transactional
    public Response updateUser( @PathParam("id") Integer id , CreateUserRequest userData){
        User user = User.findById(id);

        if(user != null){
            user.setName(userData.getName());
            user.setAge(userData.getAge());
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }





}
