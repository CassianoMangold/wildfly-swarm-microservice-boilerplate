package com.mangold.person;

import com.mangold.person.exception.PersonMandatoryFieldException;
import com.mangold.person.exception.PersonNotFoundException;
import com.mangold.person.model.PersonDAO;
import com.mangold.person.vo.PersonVO;
import com.mangold.person.model.Person;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;

public class PersonController {

    @Inject
    private PersonDAO dao;

    @Inject
    private PersonHelper personHelper;

    public Collection<PersonVO> list(){
        return this.dao.list();
    }

    public PersonVO read(long id) throws PersonNotFoundException {
        Person person = this.dao.read(id);

        if(person == null) {
            throw new PersonNotFoundException();
        }

        return this.personHelper.buildVO(person);
    }

    @Transactional
    public PersonResponse create(PersonVO personVO) throws PersonMandatoryFieldException {
        this.personHelper.validateCreateMandatoryFields(personVO);

        Person person = this.personHelper.buildEntity(personVO);

        this.dao.create(person);

        return PersonResponse.PERSON_CREATED;
    }

    @Transactional
    public PersonResponse update(PersonVO personVO) throws PersonMandatoryFieldException, PersonNotFoundException {
        this.personHelper.validateUpdateMandatoryFields(personVO);

        Person person = this.dao.read(personVO.getId());

        if(person == null) {
            throw new PersonNotFoundException();
        }

        this.personHelper.buildEntity(person, personVO);

        return PersonResponse.PERSON_UPDATED;
    }

    @Transactional
    public PersonResponse delete(long id) throws PersonNotFoundException {
        Person person = this.dao.read(id);

        if(person == null) {
            throw new PersonNotFoundException();
        }

        this.dao.delete(person);

        return PersonResponse.PERSON_DELETED;
    }
}
