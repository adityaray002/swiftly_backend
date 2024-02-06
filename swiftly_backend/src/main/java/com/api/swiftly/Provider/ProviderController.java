package com.api.swiftly.Provider;

import com.api.swiftly.Provider.dtos.CreateProviderRequest;
import com.api.swiftly.imageData.imageDataService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @Autowired
    imageDataService imageDataService;

    @PostMapping("/signup")
    public @ResponseBody ProviderEntity signupProvider(@RequestBody CreateProviderRequest createRequest){
        return providerService.createProvider(createRequest);
    }

    @GetMapping()
    public ResponseEntity<List<ProviderEntity>> getProvider(){
        List<ProviderEntity> provider = providerService.getProvider();
        return ResponseEntity.of(Optional.of(provider));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("providerId") Long providerId){
        return providerService.deleteProvider(providerId);
    }

    @PostMapping("/uploadImage/{providerId}")
    public ResponseEntity<?> uploadProviderImage(HttpServletRequest request, @PathVariable("providerId") Long providerId, @RequestParam("image") MultipartFile file) {
        if (!providerService.isProviderExists(providerId) && (file == null || file.getOriginalFilename() == null || file.getOriginalFilename().isEmpty())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Request malformed");
        }
        String fileName = imageDataService.uploadImage(file);
        if (fileName != null && !fileName.isEmpty()) {
            Optional<ProviderEntity> providerEntityOp = providerService.getProviderById(providerId);
            if (providerEntityOp.isPresent()) {
                ProviderEntity providerEntity = providerEntityOp.get();
                String baseUrl = request.getRequestURL().toString().replace("/providers/uploadImage/"+providerId,"");
                providerEntity.setImageUrl(baseUrl+"/image/"+fileName);
                ProviderEntity updatedItem = providerService.updateProvider(providerEntity);
                if (updatedItem != null) {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(updatedItem);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("File could not be uploaded");
                }
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Provider not found");
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("File could not be uploaded");
        }
    }

}
