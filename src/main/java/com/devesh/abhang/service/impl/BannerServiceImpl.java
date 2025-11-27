package com.devesh.abhang.service.impl;

import com.devesh.abhang.ExceptionHandling.Exceptions.ResourceNotFound;
import com.devesh.abhang.dto.Req.BannerReq;
import com.devesh.abhang.dto.Res.BannerRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.entity.BannerMaster;
import com.devesh.abhang.mapper.BannerMapper;
import com.devesh.abhang.repository.BannerRepository;
import com.devesh.abhang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;


    @Override
    public MainRes createBanner(BannerReq bannerReq) {

        BannerMaster bannerMaster=new BannerMaster();
        bannerMaster=BannerMapper.INSTANCE.maptoBannerMaster(bannerReq);
        bannerMaster.setStatus("Active");
        bannerMaster.setCreatedDate(LocalDate.now());
        try
        {
            bannerRepository.save(bannerMaster);
            return new MainRes(true,"true","SUCCESS", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"false","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }

    @Override
    public MainRes updateBanner(BannerReq bannerReq) {

        BannerMaster bannerMaster=new BannerMaster();
        bannerMaster=BannerMapper.INSTANCE.maptoBannerMaster(bannerReq);
        bannerMaster.setStatus("Active");
        bannerMaster.setCreatedDate(LocalDate.now());
        try
        {
            bannerMaster.setBannerId(bannerReq.getBannerId());
            bannerRepository.save(bannerMaster);
            return new MainRes(true,"true","UPDATED", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"false","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }

    }

    @Override
    public List<BannerRes> getAllBanners() {
        List<BannerMaster> bannerMasters=new ArrayList<>();
        try {
            bannerMasters = bannerRepository.findAll();
            return bannerMasters.stream().map(BannerMapper.INSTANCE::maptoBannerRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<BannerRes> getAllBannersByStatus(String status) {
        List<BannerMaster> bannerMasters=new ArrayList<>();
        try {
            bannerMasters = bannerRepository.findAllByStatus(status);
            return bannerMasters.stream().map(BannerMapper.INSTANCE::maptoBannerRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public BannerRes getById(String bannerId) {
        try {
        BannerMaster bannerMaster=new BannerMaster();
        bannerMaster=bannerRepository.findById(bannerId).orElseThrow(() -> new ResourceNotFound(" BANNER NOT FOUND OF ID ="+bannerId));
            System.out.println(" banner Master ="+bannerId);
        return BannerMapper.INSTANCE.maptoBannerRes(bannerMaster);
        }catch (Exception e)
        {
            e.printStackTrace();
            return new BannerRes();
        }
    }

    @Override
    public MainRes deleteBanner(String bannerId) {
        try {
            BannerMaster bannerMaster=new BannerMaster();
            bannerMaster=bannerRepository.findById(bannerId).orElseThrow(() -> new ResourceNotFound(" BANNER NOT FOUND OF ID ="+bannerId));
            System.out.println(" banner Master ="+bannerId);
            bannerMaster.setStatus("InActive");
            bannerRepository.save(bannerMaster);
            return new MainRes(true,"true","DELETED", LocalDateTime.now());
            }catch (Exception e) {
            e.printStackTrace();
            return new MainRes(false,"false","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }

}
