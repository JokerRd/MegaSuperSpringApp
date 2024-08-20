package ru.test.dto;

import lombok.*;

@Data
public class PersonDto {
    private final Long id;
    private final String name;
    private final Integer age;
}
