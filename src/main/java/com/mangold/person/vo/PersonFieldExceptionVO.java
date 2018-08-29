package com.mangold.person.vo;

import com.mangold.person.PersonResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class PersonFieldExceptionVO {

    private PersonResponse response;

    private Collection<String> nullMandatoryFields;
}
