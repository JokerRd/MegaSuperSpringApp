package ru.test.backend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class PersonDto {

    private final Long id;
    @NotEmpty
    private final String name;
    private final Integer age;
}
