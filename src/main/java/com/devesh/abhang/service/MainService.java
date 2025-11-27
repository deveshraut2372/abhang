package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.MainMasterReq;
import com.devesh.abhang.dto.Res.MainMasterRes;
import com.devesh.abhang.dto.Res.MainRes;

import java.util.List;

public interface MainService {

     MainRes createMain(MainMasterReq  mainMasterReq);

     MainRes updateMain(MainMasterReq  mainMasterReq);

     List<MainMasterRes> getAllMains();

     List<MainMasterRes> getAllMainsByStatus(String status);

     MainMasterRes getById(String mainId);

     MainRes deleteById(String mainId);


}
