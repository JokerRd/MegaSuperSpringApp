package ru.test.dto;

public class PersonDto {

    public PersonDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Long id;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
}
