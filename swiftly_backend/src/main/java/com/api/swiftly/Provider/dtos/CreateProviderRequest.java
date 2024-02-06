package com.api.swiftly.Provider.dtos;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateProviderRequest {
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String pincode;
    @NonNull
    private String mobileNo;
    @NonNull
    private String price;
    @NonNull
    private Long startTime;
    @NonNull
    private Long endTime;
    @NonNull
    private Long totalSlot;
    @NonNull
    private Long availableSlot;
    @Nullable
    private String imageUrl;
}
