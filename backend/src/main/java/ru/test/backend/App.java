package ru.test.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.backend.dto.DtoTest;
import ru.test.backend.mapper.TestMapper;
import ru.test.backend.mapper.TestMapperImpl;

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
