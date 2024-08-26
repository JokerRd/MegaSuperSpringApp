package ru.test.backend.util;

import org.springframework.stereotype.Service;
import ru.test.backend.service.Service1;

import java.util.Random;

@Service
public class SimpleIdService implements IdService {

    private final Random random = new Random();
    private final Service1 service1;

    public SimpleIdService(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public Long getNextId() {
        return random.nextLong();
    }
}
