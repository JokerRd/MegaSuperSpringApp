package ru.test.service;

import ru.test.configuration.ApplicationProperties;

public class Service2 {

    private final ApplicationProperties applicationProperties;

    public Service2(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }
}
