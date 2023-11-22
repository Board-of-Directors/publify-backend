package ru.nsu.fit.publify.publify.service;


public interface EmployeeMailSenderService {
    void sendRegistrationEmail(String email, String password);
}
