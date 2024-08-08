package ru.test.type;

import java.time.LocalDate;

public class PersonInfo {

    private final String name;
    private final int age;
    private final LocalDate birthday;

    public PersonInfo(String name, int age, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}
