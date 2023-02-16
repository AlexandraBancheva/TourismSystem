package com.tourismSystem.ts.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadImageToFileSystem(MultipartFile file);
}
