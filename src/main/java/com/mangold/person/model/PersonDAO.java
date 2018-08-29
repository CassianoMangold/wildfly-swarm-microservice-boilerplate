package com.mangold.person.model;

import com.mangold.person.vo.PersonVO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class PersonDAO {

    @PersistenceContext(unitName = "mangoldpersistenceunit")
    private EntityManager em;

    public Collection<PersonVO> list(){
        return this.em.createQuery("SELECT new com.mangold.person.vo.PersonVO(p.id, p.creationDate, p.lastModifiedDate, p.name, p.email, p.age, p.address) FROM Person p").getResultList();
    }

    public Person read(long id){
        return this.em.find(Person.class, id);
    }

    public void create(Person person){
        this.em.persist(person);
    }

    public void delete(Person person){
        this.em.remove(person);
    }


}
