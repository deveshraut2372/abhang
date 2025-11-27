package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.BannerReq;
import com.devesh.abhang.dto.Res.BannerRes;
import com.devesh.abhang.dto.Res.MainRes;

import java.util.List;

public interface BannerService {

    MainRes createBanner(BannerReq bannerReq);

    MainRes updateBanner(BannerReq bannerReq);

    List<BannerRes> getAllBanners();

    List<BannerRes> getAllBannersByStatus(String status);

    BannerRes getById(String bannerId);

    MainRes deleteBanner(String bannerId);


}
