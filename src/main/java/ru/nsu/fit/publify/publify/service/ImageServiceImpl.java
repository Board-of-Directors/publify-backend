package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Override
    public String save(MultipartFile multipartFile) {
        String filePath = "/images/" + multipartFile.getOriginalFilename();
        File file = new File(filePath);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return filePath;
    }

    @Override
    public File load(String path) {
        return null;
    }
}
