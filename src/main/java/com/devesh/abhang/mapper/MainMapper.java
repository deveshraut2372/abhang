package com.devesh.abhang.mapper;

import com.devesh.abhang.dto.Req.MainMasterReq;
import com.devesh.abhang.dto.Res.MainMasterRes;
import com.devesh.abhang.entity.MainMaster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MainMapper {

    MainMapper INSTANCE= Mappers.getMapper(MainMapper.class);


    MainMaster mainReqtoMainMaster(MainMasterReq mainMasterReq);

    MainMasterRes mainMasterToMainRes(MainMaster mainMaster);


}
