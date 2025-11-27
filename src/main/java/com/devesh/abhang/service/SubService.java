package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.SubMasterReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.SubMasterRes;

import java.util.List;

public interface SubService
{

    public MainRes createSubMaster(SubMasterReq subMasterReq);

    public MainRes updateSubMaster(SubMasterReq subMasterReq);

    public List<SubMasterRes> getAllSubMasters();

    public List<SubMasterRes> getAllSubMastersByStatus(String status);

    public SubMasterRes getById(String subId);

    public MainRes deleteById(String subId);


    List<SubMasterRes> getAllByMainId(String mainId);
}
