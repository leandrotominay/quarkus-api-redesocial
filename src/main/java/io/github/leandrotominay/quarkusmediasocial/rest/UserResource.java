package io.github.leandrotominay.quarkusmediasocial.rest;

import io.github.leandrotominay.domain.model.User;
import io.github.leandrotominay.domain.repository.UserRepository;
import io.github.leandrotominay.quarkusmediasocial.rest.dto.CreateUserRequest;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserRepository repository;

    @Inject
    public UserResource(UserRepository repository){

        this.repository = repository;
    }

    @POST
    @Transactional
    public Response createUser( CreateUserRequest userRequest){
        User user = new User();

        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        repository.persist(user); // Salvar no banco

        return Response.ok(user).build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = repository.findAll();
        return Response.ok(query.list()).build();
    }

    @Transactional
    @DELETE
    @Path("{id}")
    // /users/id

    public Response deleteUser( @PathParam("id") Long id){
        User user = repository.findById(id);

        if(user != null){
            repository.delete(user);
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Transactional // Sempre que for atualizar entidade no banco utilizar o metodo transactional
    public Response updateUser( @PathParam("id") Long id , CreateUserRequest userData){
        User user = repository.findById(id);

        if(user != null){
            user.setName(userData.getName());
            user.setAge(userData.getAge());
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }





}
