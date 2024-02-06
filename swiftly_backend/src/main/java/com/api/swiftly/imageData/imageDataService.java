package com.api.swiftly.imageData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;


@Service
public class imageDataService {

    @Autowired
    private imageDataRepository imageDataRepository;

    public String uploadImage(MultipartFile file){

        try{
            imageDataEntity savedItem = imageDataRepository.save(imageDataEntity.builder()
                    .name("image-"+System.currentTimeMillis())
                    .type(file.getContentType())
                    .imageData(file.getBytes()).build());
            return savedItem.getName();
        } catch (IOException e) {
            return null;
        }

    }

    public imageDataEntity getInfoByImageByName(String name) {
        Optional<imageDataEntity> dbImage = imageDataRepository.findByName(name);

        return imageDataEntity.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(dbImage.get().getImageData()).build();

    }

    public byte[] getImage(String name) {
        Optional<imageDataEntity> dbImage = imageDataRepository.findByName(name);
        byte[] image = (dbImage.get().getImageData());
        return image;
    }



}
