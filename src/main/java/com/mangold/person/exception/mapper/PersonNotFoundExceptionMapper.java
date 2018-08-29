package com.mangold.person.exception.mapper;

import com.mangold.person.PersonResponse;
import com.mangold.person.exception.PersonNotFoundException;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    @Override
    public Response toResponse(PersonNotFoundException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(PersonResponse.PERSON_NOT_FOUND).type(MediaType.APPLICATION_JSON).build();
    }
}
