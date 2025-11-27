package com.devesh.abhang.controller;

import com.devesh.abhang.dto.Req.CommentsMasterReq;
import com.devesh.abhang.dto.Res.BannerRes;
import com.devesh.abhang.dto.Res.CommentsMasterRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {


    @Autowired
    private CommentService commentService;


    @PostMapping("/createComment")
    public ResponseEntity<MainRes> createComments(@RequestBody CommentsMasterReq commentsMasterReq)
    {
        MainRes mainRes=commentService.createComments(commentsMasterReq);
        return mainRes.getFlag()? new ResponseEntity<>(mainRes, HttpStatus.CREATED): new ResponseEntity<>(mainRes,HttpStatus.BAD_REQUEST);
    }




    @PutMapping("/updateComment")
    public ResponseEntity<MainRes> updateComments(@RequestBody CommentsMasterReq commentsMasterReq)
    {
        MainRes mainRes=commentService.updateComments(commentsMasterReq);
        return mainRes.getFlag()? new ResponseEntity<>(mainRes, HttpStatus.OK): new ResponseEntity<>(mainRes,HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/getAllCommnets")
    public ResponseEntity<List<CommentsMasterRes>> getAllBanners()
    {
        List<CommentsMasterRes> commentsMasterResList=commentService.getAllComments();
        return new ResponseEntity<>(commentsMasterResList,HttpStatus.OK);
    }

    @GetMapping("/getAllCommentsByStatus/{status}")
    public ResponseEntity<List<CommentsMasterRes>> getAllCommentsByStatus(@PathVariable("status") String status)
    {
        List<CommentsMasterRes> commentsMasterResList=commentService.getAllCommentsByStatus(status);
        return new ResponseEntity<>(commentsMasterResList,HttpStatus.OK);
    }


    @GetMapping("/getById/{commentId}")
    public ResponseEntity<CommentsMasterRes> getById(@PathVariable("commentId") String commentId)
    {
        CommentsMasterRes commentsMasterRes=commentService.getById(commentId);
        return new ResponseEntity<>(commentsMasterRes,HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{commentId}")
    public ResponseEntity<MainRes> deleteById(@PathVariable("commentId") String commentId)
    {
        MainRes mainRes=commentService.deleteById(commentId);
        return mainRes.getFlag()? new ResponseEntity<>(mainRes, HttpStatus.OK): new ResponseEntity<>(mainRes,HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/getBySubId/{SubId}")
    public ResponseEntity<List<CommentsMasterRes>> getBySubId(@PathVariable("SubId") String SubId)
    {
        List<CommentsMasterRes> commentsMasterResList=commentService.getBySubId(SubId);
        return new ResponseEntity<>(commentsMasterResList, HttpStatus.OK);
    }






}
