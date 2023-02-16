package com.tourismSystem.ts.services;

import com.tourismSystem.ts.entities.Image;
import com.tourismSystem.ts.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;
    private final String FOLDER_PATH = "D:\\Projects\\TourismSystem\\TourismSystem\\src\\main\\resources\\static";

    @Override
    public String uploadImageToFileSystem(MultipartFile file) {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        Image image = imageRepository.save(Image.builder()
                                            .name(file.getOriginalFilename()
                                            .extension(file.getContentType()
                                            .filePath(filePath).build())));

        return null;
    }
}
