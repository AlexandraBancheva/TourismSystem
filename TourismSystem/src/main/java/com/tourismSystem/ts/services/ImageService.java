package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Offer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImageToFileSystem(MultipartFile file) throws IOException;
}
