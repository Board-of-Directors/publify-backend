package ru.nsu.fit.publify.publify.exception;

public class EmployeeRoleNotFoundException extends BaseException {
    public EmployeeRoleNotFoundException() {
        super("Роль работника с таким названием не найдена.");
    }
}
