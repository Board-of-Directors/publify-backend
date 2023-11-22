package ru.nsu.fit.publify.publify.exception;

public class WorkerNotFoundException extends BaseException {
    public WorkerNotFoundException() {
        super("Заданный работник не был найден в базе данных");
    }
}
