package com.devesh.abhang.controller;

import com.devesh.abhang.dto.Req.BannerReq;
import com.devesh.abhang.dto.Res.BannerRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banner")
public class BannerController {


    @Autowired
    private BannerService bannerService;



    @PostMapping
    public ResponseEntity<MainRes> createBanner(@RequestBody BannerReq bannerReq)
    {
        MainRes mainRes=bannerService.createBanner(bannerReq);
        return mainRes.getFlag()? new ResponseEntity<>(mainRes,HttpStatus.CREATED): new ResponseEntity<>(mainRes,HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<MainRes> updateBanner(@RequestBody BannerReq bannerReq)
    {
        MainRes mainRes=bannerService.updateBanner(bannerReq);
        return mainRes.getFlag()? new ResponseEntity<>(mainRes,HttpStatus.OK): new ResponseEntity<>(mainRes,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllBanners")
    public ResponseEntity<List<BannerRes>> getAllBanners()
    {
        List<BannerRes> bannerResList=bannerService.getAllBanners();
        return new ResponseEntity<>(bannerResList,HttpStatus.OK);
    }


    @GetMapping("/getAllBanners/{status}")
    public ResponseEntity<List<BannerRes>> getAllBannersByStatus(@PathVariable("status") String status)
    {
        List<BannerRes> bannerResList=bannerService.getAllBannersByStatus(status);
        return new ResponseEntity<>(bannerResList,HttpStatus.OK);
    }

    @GetMapping("/getById/{bannerId}")
    public ResponseEntity<BannerRes> getById(@PathVariable("bannerId") String bannerId)
    {
        BannerRes bannerRes=bannerService.getById(bannerId);
        return new ResponseEntity<>(bannerRes,HttpStatus.OK);
    }

    @GetMapping("/deleteBanner/{bannerId}")
    public ResponseEntity<MainRes> deleteBanner(@PathVariable("bannerId") String bannerId)
    {
        MainRes mainRes=bannerService.deleteBanner(bannerId);
        return mainRes.getFlag()?new ResponseEntity<>(mainRes,HttpStatus.OK):new ResponseEntity<>(mainRes,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
