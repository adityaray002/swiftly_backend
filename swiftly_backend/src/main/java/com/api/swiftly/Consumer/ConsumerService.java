package com.api.swiftly.Consumer;

import com.api.swiftly.Consumer.dtos.CreateConsumerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    @Autowired
    ConsumerRepository consumerRepository;

    public ConsumerEntity createUser(CreateConsumerRequest u){
        ConsumerEntity newUser = new ConsumerEntity();
      //  var newUser = ConsumerEntity.builder().ConsumerName(u.getConsumerName()).vehicleNo(u.getVehicleNo()).mobileNo(u.getMobileNo()).emailId(u.getEmailId()).build();
        newUser.setConsumerName(u.getConsumerName());
        newUser.setVehicleNo(u.getVehicleNo());
        newUser.setMobileNo(u.getMobileNo());
        newUser.setEmailId(u.getEmailId());
        return consumerRepository.save(newUser);
    }

    public List<ConsumerEntity> getUsers(){
        ArrayList<ConsumerEntity> users = new ArrayList<>();
        for (ConsumerEntity u: consumerRepository.findAll()) {
            users.add(u);
        }

        return users;
    }

    public ResponseEntity<String> deleteUser(Long id){
        consumerRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
