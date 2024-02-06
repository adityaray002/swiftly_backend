package com.api.swiftly.Consumer;

import com.api.swiftly.Consumer.dtos.CreateConsumerRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @PostMapping("/signup")
    public @ResponseBody String signupUser(@RequestBody CreateConsumerRequest request){
        ConsumerEntity savedConsumer  =  consumerService.createUser(request);
        return savedConsumer.getConsumerName();
    }

    @GetMapping("/signup")
    public ResponseEntity<List<ConsumerEntity>> getUser(){
        List<ConsumerEntity> users = consumerService.getUsers();
        return ResponseEntity.of(Optional.of(users));
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){
        return consumerService.deleteUser(userId);
    }
}
