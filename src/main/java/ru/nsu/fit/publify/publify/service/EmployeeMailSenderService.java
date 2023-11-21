package ru.nsu.fit.publify.publify.service;

import ru.nsu.fit.publify.publify.model.Employee;

public interface EmployeeMailSenderService {
    void sendRegistrationEmail(Employee employee);
}
