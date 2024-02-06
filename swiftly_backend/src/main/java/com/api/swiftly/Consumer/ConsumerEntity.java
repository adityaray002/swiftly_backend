package com.api.swiftly.Consumer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Table
public class ConsumerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String ConsumerName;

    @Column(nullable = false)
    @NonNull
    private String vehicleNo;

    @Column(nullable = false)
    @NonNull
    private String mobileNo;

    @Column(nullable = false)
    @NonNull
    private String emailId;

    public ConsumerEntity(Long id, @NonNull String consumerName, @NonNull String vehicleNo, @NonNull String mobileNo, @NonNull String emailId) {
        this.id = id;
        ConsumerName = consumerName;
        this.vehicleNo = vehicleNo;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsumerName() {
        return ConsumerName;
    }

    public void setConsumerName(String consumerName) {
        ConsumerName = consumerName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
