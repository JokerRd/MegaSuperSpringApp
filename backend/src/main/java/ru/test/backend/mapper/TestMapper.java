package ru.test.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.test.backend.dto.DtoTest;
import ru.test.backend.dto.DtoTest2;
import ru.test.backend.dto.EntityTest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {

    @Mapping(target = "phone", source = "phoneInfo")
    @Mapping(target = "email", source = "emailInfo")
    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "id", constant = "1L")
    EntityTest entityToDto(DtoTest dtoTest);

    @Mapping(target = "phone", source = "dtoTest.phoneInfo")
    @Mapping(target = "email", source = "dtoTest.emailInfo")
    @Mapping(target = "gender", source = "dtoTest.sex")
    @Mapping(target = "age", source = "dtoTest2.age")
    @Mapping(target = "id", source = "dtoTest2.id")
    EntityTest entityToDtoHard(DtoTest dtoTest, DtoTest2 dtoTest2);

    @Mapping(target = "phone", source = "phoneInfo")
    @Mapping(target = "email", source = "emailInfo")
    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "id", constant = "1L")
    void entityToDto(DtoTest dtoTest, @MappingTarget EntityTest entityTest);

    @Mapping(target = "phoneInfo", source = "phone")
    @Mapping(target = "emailInfo", source = "email")
    @Mapping(target = "sex", source = "gender")
    DtoTest dtoToEntity(EntityTest entityTest);

    List<EntityTest> dtoListToEntityList(List<DtoTest> dtoList);

}
