package com.api.swiftly.Provider;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<ProviderEntity,Long> {
}
