package ru.test.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.test.backend.mapper.PersonRowMapper;
import ru.test.backend.repository.PersonRepository;

import java.sql.SQLException;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(App.class, args);
        var repo = context.getBean(PersonRepository.class);
        System.out.println(repo.getAll());
    }


}
