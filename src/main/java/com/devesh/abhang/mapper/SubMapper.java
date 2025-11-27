package com.devesh.abhang.mapper;


import com.devesh.abhang.dto.Req.SubMasterReq;
import com.devesh.abhang.dto.Res.SubMasterRes;
import com.devesh.abhang.entity.SubMaster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubMapper {


    SubMapper INSTANCE= Mappers.getMapper(SubMapper.class);


    SubMaster maptoSubMaster(SubMasterReq subMasterReq);

    SubMasterRes maptoSubMasterRes(SubMaster subMaster);

}
