package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class ImageUploadController {
    public String uploadImage(MultipartFile image) {
        try {
            String fileName = image.getOriginalFilename();
            String uploadDir = "src/main/resources/static/carousel";

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
