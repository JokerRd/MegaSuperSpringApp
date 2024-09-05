package ru.test.backend.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.mapstruct.Mapper;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    default Map<String, Object> toMap(Object filter) {
        TypeFactory typeFactory = OBJECT_MAPPER.getTypeFactory();
        return OBJECT_MAPPER.convertValue(filter, typeFactory.constructMapType(Map.class, String.class, Object.class));
    }
}
