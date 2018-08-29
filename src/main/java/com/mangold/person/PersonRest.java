package com.mangold.person;

import com.mangold.person.exception.PersonMandatoryFieldException;
import com.mangold.person.exception.PersonNotFoundException;
import com.mangold.person.vo.PersonVO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@ApplicationScoped
@Path("/person")
public class PersonRest {

    @Inject
    private PersonController controller;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<PersonVO> list(){
        return this.controller.list();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonResponse create(PersonVO personVO) throws PersonMandatoryFieldException {
        return this.controller.create(personVO);
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonVO read(@PathParam("id") long id) throws PersonNotFoundException {
        return this.controller.read(id);
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonResponse update(PersonVO personVO) throws PersonNotFoundException, PersonMandatoryFieldException {
        return this.controller.update(personVO);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonResponse delete(@PathParam("id") long id) throws PersonNotFoundException {
        return this.controller.delete(id);
    }
}
