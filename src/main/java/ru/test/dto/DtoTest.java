package ru.test.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DtoTest {

    private String name;
    private int age;
    private String birthday;
    private String sex;
    private String address;
    private String phoneInfo;
    private String emailInfo;

}
