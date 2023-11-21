package ru.nsu.fit.publify.publify.exception;

public class AlreadyRegisteredException extends BaseException {
    public AlreadyRegisteredException() {
        super("Работники или организация с такими данными уже зарегистрированы.");
    }
}
