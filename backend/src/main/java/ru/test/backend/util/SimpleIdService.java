package ru.test.backend.util;

import org.springframework.stereotype.Service;
import ru.test.backend.service.Service1;

import java.util.Random;

@Service
public class SimpleIdService implements IdService {

    private final Random random = new Random();


    @Override
    public Long getNextId() {
        return (long) random.nextInt(100);
    }
}
