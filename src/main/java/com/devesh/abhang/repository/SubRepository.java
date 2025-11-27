package com.devesh.abhang.repository;

import com.devesh.abhang.entity.SubMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubRepository extends MongoRepository<SubMaster,String> {

    List<SubMaster> findAllByStatus(String status);

    List<SubMaster> findAllByMainId(String mainId);
}
