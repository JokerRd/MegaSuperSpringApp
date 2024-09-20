package ru.test.backend.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.test.backend.cache.PersonCache;
import ru.test.backend.model.Person;

import static org.assertj.core.api.Assertions.*;

public class PersonCacheTest {

    private PersonCache personCache;
    private static Person person;

    @BeforeEach
    public void setUp() {
        personCache = new PersonCache();
    }

    @BeforeAll
    public static void setUpBeforeClass() {
        person = new Person();
    }

    @Test
    public void valuePutInCache() {
        personCache.put(1L, person);
        var result = personCache.get(1L);

        assertThat(result).isEqualTo(person);
    }

    @Test
    public void invalidateValueInCache() {
        personCache.put(1L, person);
        personCache.invalidate(1L);
        var result = personCache.get(1L);

        assertThat(result).isNull();
    }

}
