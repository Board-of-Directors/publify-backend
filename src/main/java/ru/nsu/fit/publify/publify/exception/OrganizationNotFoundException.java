package ru.nsu.fit.publify.publify.exception;

public class OrganizationNotFoundException extends BaseException {
    public OrganizationNotFoundException(Long id) {
        super("Организация с идентификатором %s не найдена".formatted(id));
    }
}
