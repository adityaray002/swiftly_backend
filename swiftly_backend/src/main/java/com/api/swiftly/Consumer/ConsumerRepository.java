package com.api.swiftly.Consumer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsumerRepository extends CrudRepository<ConsumerEntity,Long> {

}
