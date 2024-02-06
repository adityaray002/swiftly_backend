package com.api.swiftly.Provider;

import com.api.swiftly.Provider.dtos.CreateProviderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    public ProviderEntity createProvider(CreateProviderRequest u){
        ProviderEntity newProvider =  new ProviderEntity();
        newProvider.setName(u.getName());
        newProvider.setMobileNo(u.getMobileNo());
        newProvider.setAddress(u.getAddress());
        newProvider.setPincode(u.getPincode());
        newProvider.setAvailableSlot(u.getAvailableSlot());
        newProvider.setTotalSlot(u.getTotalSlot());
        newProvider.setStartTime(u.getStartTime());
        newProvider.setEndTime(u.getEndTime());
        newProvider.setImageUrl(u.getImageUrl());
        newProvider.setPrice(u.getPrice());
        return providerRepository.save(newProvider);
    }

    public ProviderEntity updateProvider(ProviderEntity providerEntity){
        return providerRepository.save(providerEntity);
    }

    public List<ProviderEntity> getProvider(){
        ArrayList<ProviderEntity> provider = new ArrayList<>();
        for (ProviderEntity u: providerRepository.findAll()) {
            provider.add(u);
        }

        return provider;
    }

    public Optional<ProviderEntity> getProviderById(Long id){
        return providerRepository.findById(id);
    }

    public Boolean isProviderExists(Long id){
        return providerRepository.existsById(id);
    }

    public ResponseEntity<String> deleteProvider(Long id){
        providerRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    public ResponseEntity<String> getImageUrl(){
//        String url = "/image/"+ imageDataService.getInfoByImageByName();
//    }
}
