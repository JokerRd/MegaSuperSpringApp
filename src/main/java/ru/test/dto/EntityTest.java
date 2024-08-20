package ru.test.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EntityTest {

    private Long id;
    private String name;
    private int age;
    private LocalDate birthday;
    private String gender;
    private String address;
    private String phone;
    private String email;

}
