package com.api.swiftly.imageData;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface imageDataRepository extends CrudRepository<imageDataEntity,Long> {

    Optional<imageDataEntity> findByName(String name);
}
