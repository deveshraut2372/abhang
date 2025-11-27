package com.devesh.abhang.mapper;

import com.devesh.abhang.dto.Req.BannerReq;
import com.devesh.abhang.dto.Res.BannerRes;
import com.devesh.abhang.entity.BannerMaster;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BannerMapper {

    BannerMapper INSTANCE= Mappers.getMapper(BannerMapper.class);

    BannerMaster maptoBannerMaster(BannerReq bannerReq);

    BannerRes maptoBannerRes(BannerMaster bannerMaster);

}
