package ru.test.backend.integration;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PersonExternalSourceStub implements PersonExternalSource {

    private final List<TrustedPerson> trustedPersonList = List.of(
            new TrustedPerson("Федор", 18),
            new TrustedPerson("Влад", 18)
    );

    @Override
    public boolean isTrustedPerson(String name, int age) {
        var potentialTrustedPerson = new TrustedPerson(name, age);
        return trustedPersonList.contains(potentialTrustedPerson);
    }

    class TrustedPerson {
        private final String name;
        private final int age;

        TrustedPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TrustedPerson that = (TrustedPerson) o;
            return age == that.age && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            int result = Objects.hashCode(name);
            result = 31 * result + age;
            return result;
        }
    }
}
