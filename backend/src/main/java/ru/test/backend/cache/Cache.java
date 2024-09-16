package ru.test.backend.cache;

public interface Cache<Entity> {

    //Он должен класть в кэш, обновлять существующие
    void put(Long id, Entity value);


    //Возвращает значение из кэша если оно есть
    Entity get(Long id);

    //Удаляет значение из кэша
    void invalidate(Long id);

}
