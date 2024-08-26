package ru.test.backend.service;

import org.springframework.stereotype.Component;

@Component
public class Service1 {

    private final Service2 service2;

    public Service1(Service2 service2) {
        this.service2 = service2;
    }

    public Service2 getService2() {
        return service2;
    }
}
