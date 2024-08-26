package ru.test.backend.service;

import ru.test.backend.configuration.ApplicationProperties;

public class Service2 {

    private final ApplicationProperties applicationProperties;

    public Service2(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }
}
