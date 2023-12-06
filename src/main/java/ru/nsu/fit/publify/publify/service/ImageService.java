package ru.nsu.fit.publify.publify.service;

public interface ImageService {
    String save(byte[] file, String journalTitle, Integer number);

    byte[] load(String path);
}
