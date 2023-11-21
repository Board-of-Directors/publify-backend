package ru.nsu.fit.publify.publify.enums;

import jakarta.annotation.Nonnull;
import ru.nsu.fit.publify.publify.exception.EmployeeRoleNotFoundException;

import java.util.stream.Stream;

public enum EmployeeRole {
    OWNER,
    EDITOR,
    AUTHOR,
    ILLUSTRATOR;

    @Nonnull
    public static EmployeeRole fromString(String role) {
        return Stream.of(values())
            .filter(roleName -> roleName.name().equals(role))
            .findFirst()
            .orElseThrow(EmployeeRoleNotFoundException::new);
    }
}
