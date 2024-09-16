package ru.test.backend.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.test.backend.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getLong("id");
        var name = rs.getString("name");
        var age = rs.getInt("age");
        return new Person(id, name, age, null, null);
    }

}
