package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.CommentsMasterReq;
import com.devesh.abhang.dto.Res.CommentsMasterRes;
import com.devesh.abhang.dto.Res.MainRes;

import java.util.List;

public interface CommentService {

     MainRes createComments(CommentsMasterReq commentsMasterReq);

     MainRes updateComments(CommentsMasterReq commentsMasterReq);

     List<CommentsMasterRes> getAllComments();

     List<CommentsMasterRes> getAllCommentsByStatus(String status);

     CommentsMasterRes getById(String commentId);

     MainRes deleteById(String commentId);

          List<CommentsMasterRes> getBySubId(String SubId);

}
