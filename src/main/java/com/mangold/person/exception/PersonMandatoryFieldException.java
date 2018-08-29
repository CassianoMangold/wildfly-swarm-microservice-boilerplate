package com.mangold.person.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonMandatoryFieldException extends PersonException {

    private Collection<String> nullMandatoryFields;
}
