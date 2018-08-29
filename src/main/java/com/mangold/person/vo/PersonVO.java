package com.mangold.person.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO {

    private Long id;

    private Date creationDate;

    private Date lastModifiedDate;

    private String name;

    private String email;

    private int age;

    private String address;
}
