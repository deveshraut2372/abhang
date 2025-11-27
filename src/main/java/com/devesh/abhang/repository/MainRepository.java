package com.devesh.abhang.repository;

import com.devesh.abhang.entity.MainMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MainRepository extends MongoRepository<MainMaster,String> {

    List<MainMaster> findAllByStatus(String status);
}
