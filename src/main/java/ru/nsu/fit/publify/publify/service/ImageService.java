package ru.nsu.fit.publify.publify.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImageService {
    String save(MultipartFile file);

    File load(String path);
}
