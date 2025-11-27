package com.devesh.abhang.repository;

import com.devesh.abhang.entity.BannerMaster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends MongoRepository<BannerMaster,String> {


    List<BannerMaster> findAllByStatus(String status);
}
