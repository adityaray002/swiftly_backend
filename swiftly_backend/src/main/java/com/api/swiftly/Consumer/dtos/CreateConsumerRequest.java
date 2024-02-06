package com.api.swiftly.Consumer.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreateConsumerRequest {
    @NonNull
    private String ConsumerName;
    @NonNull
    private String vehicleNo;
   @NonNull
    private String mobileNo;
   @NonNull
   private String emailId;
}
