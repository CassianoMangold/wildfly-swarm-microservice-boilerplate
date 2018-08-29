package com.mangold.person;

import com.mangold.person.exception.PersonMandatoryFieldException;
import com.mangold.person.vo.PersonVO;
import com.mangold.person.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PersonHelper {

    public Person buildEntity(PersonVO personVO) {
        return this.buildEntity(null, personVO);
    }

    public Person buildEntity(Person person, PersonVO personVO){
        if(person == null){
            person = new Person();
        }
        person.setName(personVO.getName());
        person.setEmail(personVO.getEmail());
        person.setAge(personVO.getAge());
        person.setAddress(personVO.getAddress());

        return person;
    }

    public PersonVO buildVO(Person person){
        if(person == null){
            return null;
        }

        PersonVO personVO = new PersonVO();
        personVO.setId(person.getId());
        personVO.setCreationDate(person.getCreationDate());
        personVO.setLastModifiedDate(person.getLastModifiedDate());
        personVO.setName(person.getName());
        personVO.setEmail(person.getEmail());
        personVO.setAge(person.getAge());
        personVO.setAddress(person.getAddress());

        return personVO;
    }

    public void validateCreateMandatoryFields(PersonVO personVO) throws PersonMandatoryFieldException {
        Collection<String> mandatoryFields = new ArrayList<>();

        if(personVO == null){
            throw new PersonMandatoryFieldException(Arrays.asList("name", "email"));
        }

        if(personVO.getName() == null){
            mandatoryFields.add("name");
        }
        if(personVO.getEmail() == null){
            mandatoryFields.add("email");
        }

        if(!mandatoryFields.isEmpty()){
            throw new PersonMandatoryFieldException(mandatoryFields);
        }
    }

    public void validateUpdateMandatoryFields(PersonVO personVO) throws PersonMandatoryFieldException {
        if(personVO == null || personVO.getId() == null){
            throw new PersonMandatoryFieldException(Collections.singletonList("id"));
        }
    }

}
