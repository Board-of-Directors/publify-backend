package ru.nsu.fit.publify.publify.exception;

import ru.nsu.fit.publify.publify.enums.EntityType;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(EntityType type, Long id) {
        super("Сущность " + type + " с идентификатором " + id + " не была найдена");
    }

    public EntityNotFoundException(EntityType type, String name) {
        super("Сущность " + type + " с названием " + name + " не была найдена");
    }
}
