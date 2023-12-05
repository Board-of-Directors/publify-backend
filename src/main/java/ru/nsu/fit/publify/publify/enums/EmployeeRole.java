package ru.nsu.fit.publify.publify.enums;

import jakarta.annotation.Nonnull;
import ru.nsu.fit.publify.publify.exception.EmployeeRoleNotFoundException;

import java.util.stream.Stream;

public enum EmployeeRole {
    OWNER,
    EDITOR,
    COPYRIGHTER,
    ILLUSTRATOR;

    @Nonnull
    public static EmployeeRole fromString(String role) {
        return Stream.of(values())
            .filter(roleName -> roleName.name().equalsIgnoreCase(role))
            .findFirst()
            .orElseThrow(EmployeeRoleNotFoundException::new);
    }
}
