package com.example.demo.Controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
@RequestMapping("/public/download")
public class FileDownloadController {

    private final ResourceLoader resourceLoader;

    public FileDownloadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            Resource resource = resourceLoader.getResource("classpath:/files/" + filename);
            String contentType = "application/octet-stream"; // По умолчанию, если тип неизвестен

            // Определение MIME-типа файла на основе его расширения
            MediaType mediaType = MediaType.parseMediaType(Objects.requireNonNull(resource.getURL().openConnection().getContentType()));
            contentType = mediaType.toString();

            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
