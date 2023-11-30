package ru.nsu.fit.publify.publify.exception;

public class JournalNotFoundException extends BaseException {
    public JournalNotFoundException(Long journalId) {
        super("Не найден журнал с идентификатором " + journalId);
    }
}
