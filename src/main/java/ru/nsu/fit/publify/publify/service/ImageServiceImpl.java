package ru.nsu.fit.publify.publify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Override
    public String save(byte[] coverFile, String journalTitle, Integer number) {
        String filePath = "/images/" + journalTitle + "_" + number;
        File file = new File(filePath);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(coverFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return filePath;
    }

    @Override
    public byte[] load(String path) {
        File file = new File(path);
        try (InputStream inputStream = new FileInputStream(file)) {
            return inputStream.readAllBytes();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
