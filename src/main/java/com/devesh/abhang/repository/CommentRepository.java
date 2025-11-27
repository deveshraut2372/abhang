package com.devesh.abhang.repository;

import com.devesh.abhang.entity.CommentsMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<CommentsMaster,String> {

    List<CommentsMaster> findAllByStatus(String status);

    List<CommentsMaster> findAllBySubId(String subId);
}
