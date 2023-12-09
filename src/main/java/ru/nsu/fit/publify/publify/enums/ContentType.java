package ru.nsu.fit.publify.publify.enums;

import jakarta.annotation.Nonnull;
import ru.nsu.fit.publify.publify.exception.EntityNotFoundException;

import java.util.stream.Stream;

public enum ContentType {
    TEXT,
    IMAGE,
    ;

    @Nonnull
    public static ContentType fromString(String type) {
        return Stream.of(values())
            .filter(roleName -> roleName.name().equalsIgnoreCase(type))
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException(EntityType.CONTENT_TYPE, type));
    }
}
