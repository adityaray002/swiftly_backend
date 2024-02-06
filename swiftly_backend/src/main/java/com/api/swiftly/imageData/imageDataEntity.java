package com.api.swiftly.imageData;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="imageData")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class imageDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;

    @Lob
    @Column(name="imageData",length=1000)
    private byte[] imageData;

}
