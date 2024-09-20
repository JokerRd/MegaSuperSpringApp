package ru.test.backend.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.test.backend.util.SimpleIdService;

public class SimpleIdServiceTest {


    @Test
    public void getNextLongNumberLess100() {
        var simpleIdService = new SimpleIdService();

        var result = simpleIdService.getNextId();

        Assertions.assertTrue(result < 100L);
    }


}
