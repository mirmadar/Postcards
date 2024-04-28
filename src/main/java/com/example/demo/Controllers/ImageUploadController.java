package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class ImageUploadController {

    public String uploadImage(MultipartFile image) {
        try {
            String fileName = image.getOriginalFilename();
            String uploadDir = "/app/static/carousel"; // Путь внутри контейнера Docker

            // Создаем директорию, если она не существует
            Files.createDirectories(Paths.get(uploadDir));

            assert fileName != null;
            try (FileOutputStream outputStream = new FileOutputStream(new File(uploadDir, fileName))) {
                FileCopyUtils.copy(image.getInputStream(), outputStream);
            }

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
