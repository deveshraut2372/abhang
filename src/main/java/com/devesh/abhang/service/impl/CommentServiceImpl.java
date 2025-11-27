package com.devesh.abhang.service.impl;

import com.devesh.abhang.dto.Req.CommentsMasterReq;
import com.devesh.abhang.dto.Res.CommentsMasterRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.entity.CommentsMaster;
import com.devesh.abhang.mapper.CommentMapper;
import com.devesh.abhang.repository.CommentRepository;
import com.devesh.abhang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public MainRes createComments(CommentsMasterReq commentsMasterReq)
    {
        CommentsMaster commentsMaster=new CommentsMaster();
        commentsMaster= CommentMapper.INSTANCE.maptoCommentMaster(commentsMasterReq);
        try
        {
            System.out.println(" commentsMaster ="+commentsMaster.toString());
            commentRepository.save(commentsMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public MainRes updateComments(CommentsMasterReq commentsMasterReq)
    {
        CommentsMaster commentsMaster=new CommentsMaster();
        commentsMaster= CommentMapper.INSTANCE.maptoCommentMaster(commentsMasterReq);
        try
        {
            commentsMaster.setCommentId(commentsMasterReq.getCommentId());
            System.out.println(" commentsMaster ="+commentsMaster.toString());
            commentRepository.save(commentsMaster);
            return new MainRes(true,"Updated","UPDATED", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public List<CommentsMasterRes> getAllComments()
    {
        try {
            List<CommentsMaster> commentsMasters = commentRepository.findAll();
            return commentsMasters.stream().map(CommentMapper.INSTANCE::maptoCommentMasterRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public List<CommentsMasterRes> getAllCommentsByStatus(String status)
    {
        try {
            List<CommentsMaster> commentsMasters = commentRepository.findAllByStatus(status);
            return commentsMasters.stream().map(CommentMapper.INSTANCE::maptoCommentMasterRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public CommentsMasterRes getById(String commentId)
    {
        try {

            CommentsMaster commentsMaster=commentRepository.findById(commentId).get();
            CommentsMasterRes commentsMasterRes=CommentMapper.INSTANCE.maptoCommentMasterRes(commentsMaster);
            System.out.println(" commentsMasterRes ="+commentsMasterRes.toString());
            return commentsMasterRes;
        }catch (Exception e)
        {
            e.printStackTrace();
            return new CommentsMasterRes();
        }
    }



    public MainRes deleteById(String commentId)
    {
        try {
            CommentsMaster commentsMaster=commentRepository.findById(commentId).get();
            commentsMaster.setStatus("InActive");
            commentRepository.save(commentsMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e) {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public List<CommentsMasterRes> getBySubId(String SubId)
    {
        try {
            List<CommentsMaster> commentsMasters=commentRepository.findAllBySubId(SubId);
            return commentsMasters.stream().map(CommentMapper.INSTANCE::maptoCommentMasterRes).collect(Collectors.toList());
        }catch (Exception e) {
            e.printStackTrace();
           return new ArrayList<>();
        }
    }


}
