package com.devesh.abhang.service.impl;

import com.devesh.abhang.dto.Req.SubMasterReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.SubMasterRes;
import com.devesh.abhang.entity.SubMaster;
import com.devesh.abhang.mapper.SubMapper;
import com.devesh.abhang.repository.SubRepository;
import com.devesh.abhang.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubServiceImpl implements SubService {

    @Autowired
    private SubRepository subRepository;


    public MainRes createSubMaster(SubMasterReq subMasterReq)
    {
        SubMaster subMaster=new SubMaster();
        subMaster= SubMapper.INSTANCE.maptoSubMaster(subMasterReq);
        subMaster.setMainId(subMasterReq.getMainId());
        try
        {
            System.out.println(" Sub Master ="+subMaster.toString());
            subRepository.save(subMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public MainRes updateSubMaster(SubMasterReq subMasterReq)
    {
        SubMaster subMaster=new SubMaster();
        subMaster= SubMapper.INSTANCE.maptoSubMaster(subMasterReq);
        subMaster.setMainId(subMasterReq.getMainId());
        try
        {
            subMaster.setSubId(subMasterReq.getSubId());
            System.out.println(" subMaster ="+subMaster.toString());
            subRepository.save(subMaster);
            return new MainRes(true,"Updated","UPDATED", LocalDateTime.now());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }


    public List<SubMasterRes> getAllSubMasters()
    {
        try {
            List<SubMaster> subMasterList = subRepository.findAll();
            return subMasterList.stream().map(SubMapper.INSTANCE::maptoSubMasterRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public List<SubMasterRes> getAllSubMastersByStatus(String status)
    {
        try {
            List<SubMaster> subMasters = subRepository.findAllByStatus(status);
            return subMasters.stream().map(SubMapper.INSTANCE::maptoSubMasterRes).collect(Collectors.toList());
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public SubMasterRes getById(String subId)
    {
        try {

            SubMaster subMaster=subRepository.findById(subId).get();
            SubMasterRes subMasterRes=SubMapper.INSTANCE.maptoSubMasterRes(subMaster);
            System.out.println(" subMasterRes ="+subMasterRes.toString());
            return subMasterRes;
        }catch (Exception e)
        {
            e.printStackTrace();
            return new SubMasterRes();
        }
    }



    public MainRes deleteById(String subId)
    {
        try {
            SubMaster subMaster=subRepository.findById(subId).get();
            subMaster.setStatus("InActive");
            subRepository.save(subMaster);
            return new MainRes(true,"Success","SUCCESS", LocalDateTime.now());
        }catch (Exception e) {
            e.printStackTrace();
            return new MainRes(false,"Something went wrong !","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }

    @Override
    public List<SubMasterRes> getAllByMainId(String mainId) {
        List<SubMaster> subMasters=subRepository.findAllByMainId(mainId);
        return subMasters.stream().map(SubMapper.INSTANCE::maptoSubMasterRes).collect(Collectors.toList());
    }

}
