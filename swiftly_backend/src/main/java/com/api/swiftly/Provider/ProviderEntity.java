package com.api.swiftly.Provider;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String pincode;
    @Column(nullable = false)
    private String mobileNo;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private Long startTime;
    @Column(nullable = false)
    private Long endTime;
    @Column(nullable = false)
    private Long totalSlot;
    @Column(nullable = false)
    private Long availableSlot;
    @Column(nullable = true)
    private String imageUrl;

}
