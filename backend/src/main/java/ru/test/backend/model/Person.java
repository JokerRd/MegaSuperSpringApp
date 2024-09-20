package ru.test.backend.model;

import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_seq")
    @SequenceGenerator(name = "persons_seq", sequenceName = "persons_seq", allocationSize = 1, initialValue = 100)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = LAZY)
    private List<Hobby> hobbies;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Dog> dogs;
}
