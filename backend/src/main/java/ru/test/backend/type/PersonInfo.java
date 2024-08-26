package ru.test.backend.type;

import ru.test.backend.validation.ValidBirthday;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ValidBirthday(nameField = "birthday")
public class PersonInfo {

    @NotNull
    @NotEmpty
    private final String name;

    @Min(10)
    private final Integer age;

    private final LocalDate birthday;

    public PersonInfo(String name, Integer age, LocalDate birthday) {
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
