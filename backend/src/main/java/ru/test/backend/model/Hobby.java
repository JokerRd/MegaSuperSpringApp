package ru.test.backend.model;

import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "hobbies")
@ToString
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hobbies_seq")
    @SequenceGenerator(name = "hobbies_seq", sequenceName = "hobbies_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    @ToString.Exclude
    private Person person;

}
