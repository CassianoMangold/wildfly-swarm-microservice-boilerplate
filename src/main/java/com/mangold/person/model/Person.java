package com.mangold.person.model;

import com.mangold.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Person extends BaseEntity {

    private String name;

    private String email;

    private int age;

    private String address;
}
