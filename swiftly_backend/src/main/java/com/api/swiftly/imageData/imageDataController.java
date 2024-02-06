package com.api.swiftly.imageData;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class imageDataController {
    @Autowired
     imageDataService imageDataService;

    @PostMapping
    public ResponseEntity<?> uploadImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
        String fileName = imageDataService.uploadImage(file);

        if (fileName != null && !fileName.isEmpty()) {
            String baseUrl = request.getRequestURL().toString();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(baseUrl+"/"+fileName);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Image could not be uploaded");
        }


    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
        imageDataEntity image = imageDataService.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?>  getImageByName(@PathVariable("name") String name){
        byte[] image = imageDataService.getImage(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }




}
