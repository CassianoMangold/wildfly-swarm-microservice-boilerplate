package com.mangold.person.exception.mapper;

import com.mangold.person.PersonResponse;
import com.mangold.person.exception.PersonMandatoryFieldException;
import com.mangold.person.vo.PersonFieldExceptionVO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonMandatoryFieldExceptionMapper implements ExceptionMapper<PersonMandatoryFieldException> {

    @Override
    public Response toResponse(PersonMandatoryFieldException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new PersonFieldExceptionVO(PersonResponse.NULL_MANDATORY_FIELDS, exception.getNullMandatoryFields())).type(MediaType.APPLICATION_JSON).build();
    }
}
