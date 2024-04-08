package com.example.server.repos;

import com.example.server.domain.Data;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DataRepository extends MongoRepository<Data, String> {

    boolean existsByIdIgnoreCase(String id);

}
