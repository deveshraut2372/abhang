package com.devesh.abhang.mapper;

import com.devesh.abhang.dto.Req.CommentsMasterReq;
import com.devesh.abhang.dto.Res.CommentsMasterRes;
import com.devesh.abhang.entity.CommentsMaster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {


    CommentMapper INSTANCE= Mappers.getMapper(CommentMapper.class);


    CommentsMaster maptoCommentMaster(CommentsMasterReq commentsMasterReq);

    CommentsMasterRes maptoCommentMasterRes(CommentsMaster commentsMaster);


}
