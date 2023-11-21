package ru.nsu.fit.publify.publify.exception;

public class UserNotLoggedInException extends BaseException {
    public UserNotLoggedInException() {
        super("Пользователь не вошел в аккаунт");
    }
}
