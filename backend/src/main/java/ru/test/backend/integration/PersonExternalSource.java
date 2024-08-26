package ru.test.backend.integration;

public interface PersonExternalSource {

    boolean isTrustedPerson(String name, int age);

}
