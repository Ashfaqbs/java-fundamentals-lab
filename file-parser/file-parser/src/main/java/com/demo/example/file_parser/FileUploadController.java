package com.demo.example.file_parser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final ClamAVService clamAVService;

    public FileUploadController(ClamAVService clamAVService) {
        this.clamAVService = clamAVService;
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Step 1: File Size Check
            if (file.getSize() > 10 * 1024 * 1024) { // Limit to 10 MB but we can also check min and max size as per file extension type
                return "Failed to upload: File size is too large.";
            }

            // Step 2: File Extension Check
            String fileName = file.getOriginalFilename();
            if (fileName == null || !fileName.endsWith(".txt")) { // Example: Allow only `.txt` files for now, but only allow png, jpg, txt, excel etc...
                return "Failed to upload: Invalid file extension.";
            }

            // Step 3: Antivirus Check
            boolean isInfected = clamAVService.scanFile(file.getBytes());
            if (isInfected) {
                return "Failed to upload: File is infected.";
            }

            // Step 4: File Integrity Check
            if (!isFileReadable(file)) {
                return "Failed to upload: File is corrupted.";
            }

            // Successful Upload
            return "File uploaded successfully: " + fileName;

        } catch (Exception e) {
            return "Failed to upload: An error occurred.";
        }
    }

    private boolean isFileReadable(MultipartFile file) {
        try {
            file.getInputStream().read(); // Attempt to read file data
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}