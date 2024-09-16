package ru.test.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dogs_seq")
    @SequenceGenerator(name = "dogs_seq", sequenceName = "dogs_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    private String name;
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    List<Person> persons;

}
