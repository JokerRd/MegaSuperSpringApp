package ru.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.dto.BuilderTest;
import ru.test.dto.DtoTest;
import ru.test.dto.EntityTest;
import ru.test.dto.PersonDto;
import ru.test.mapper.TestMapper;
import ru.test.mapper.TestMapperImpl;
import ru.test.service.Service2;

import java.time.LocalDate;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        var context = SpringApplication.run(App.class, args);
        var dtoTest = new DtoTest("Иван",
                10, "2023-01-01", "М",
                "улица Кукева 20", "нет", "test@mail.ru");
        TestMapper mapper = new TestMapperImpl();
        var entityTest = mapper.entityToDto(dtoTest);
        var newDtoTest = mapper.dtoToEntity(entityTest);
        System.out.println(entityTest);
        System.out.println(newDtoTest);
    }


}
