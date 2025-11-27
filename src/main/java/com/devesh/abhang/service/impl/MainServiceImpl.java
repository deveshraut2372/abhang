package com.devesh.abhang.service.impl;

import com.devesh.abhang.dto.Req.MainMasterReq;
import com.devesh.abhang.dto.Res.MainMasterRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.entity.MainMaster;
import com.devesh.abhang.mapper.MainMapper;
import com.devesh.abhang.repository.MainRepository;
import com.devesh.abhang.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainRepository mainRepository;


    public MainRes createMain(MainMasterReq  mainMasterReq)
    {
        MainMaster mainMaster=new MainMaster();
        mainMaster= MainMapper.INSTANCE.mainReqtoMainMaster(mainMasterReq);
        try
        {
            mainMaster.setStatus("Active");
            mainMaster.setCreatedDate(LocalDate.now());
            System.out.println(" Main Master ="+mainMaster.toString());
            mainRepository.save(mainMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public MainRes updateMain(MainMasterReq  mainMasterReq)
    {
        MainMaster mainMaster=new MainMaster();
        mainMaster= MainMapper.INSTANCE.mainReqtoMainMaster(mainMasterReq);
        try
        {
            mainMaster.setMainId(mainMasterReq.getMainId());
            mainMaster.setStatus(mainMasterReq.getStatus());
            System.out.println(" Main Master ="+mainMaster.toString());
            mainRepository.save(mainMaster);
            return new MainRes(true,"Updated","UPDATED", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public List<MainMasterRes> getAllMains()
    {
        try {
            System.out.println(" call main Master ");
            List<MainMaster> mainMasters = mainRepository.findAll();
            System.out.println("  mainMaster ="+mainMasters.toString());
            return mainMasters.stream().map(MainMapper.INSTANCE::mainMasterToMainRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public List<MainMasterRes> getAllMainsByStatus(String status)
    {
        try {
            List<MainMaster> mainMasters = mainRepository.findAllByStatus(status);
            return mainMasters.stream().map(MainMapper.INSTANCE::mainMasterToMainRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public MainMasterRes getById(String mainId)
    {
        try {

            MainMaster mainMaster=mainRepository.findById(mainId).get();
            MainMasterRes mainMasterRes=MainMapper.INSTANCE.mainMasterToMainRes(mainMaster);
            System.out.println(" main Master Res ="+mainMasterRes.toString());
            return mainMasterRes;
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainMasterRes();
        }
    }



    public MainRes deleteById(String mainId)
    {
        try {
            MainMaster mainMaster=mainRepository.findById(mainId).get();
            mainMaster.setStatus("InActive");
            mainRepository.save(mainMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e) {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


}
