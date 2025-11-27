package com.devesh.abhang.controller;


import com.devesh.abhang.dto.Req.SubMasterReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.SubMasterRes;
import com.devesh.abhang.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/subMaster")
public class SubController {

    @Autowired
    private SubService subService;



    @PostMapping
    public ResponseEntity<MainRes> createSubMaster(@RequestBody SubMasterReq subMasterReq)
    {
        MainRes mainRes=subService.createSubMaster(subMasterReq);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    public ResponseEntity<MainRes> updateSubMaster(@RequestBody SubMasterReq subMasterReq)
    {
        MainRes mainRes=subService.updateSubMaster(subMasterReq);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<SubMasterRes>> getAllSubMasters()
    {
        List<SubMasterRes> subMasterResList=subService.getAllSubMasters();
        return new ResponseEntity<>(subMasterResList, HttpStatus.OK);
    }


    @GetMapping("/getByStatus/{status}")
    public ResponseEntity<List<SubMasterRes>> getAllSubMastersByStatus(@PathVariable("status") String status)
    {
        List<SubMasterRes> subMasterResList=subService.getAllSubMastersByStatus(status);
        return new ResponseEntity<>(subMasterResList, HttpStatus.OK);
    }


    @GetMapping("/getById/{subId}")
    public ResponseEntity<SubMasterRes> getById(@PathVariable("subId") String subId)
    {
        SubMasterRes subMasterRes=subService.getById(subId);
        return new ResponseEntity<>(subMasterRes, HttpStatus.OK);
    }

    @GetMapping("deleteById/{subId}")
    public ResponseEntity<MainRes> deleteById(@PathVariable("subId") String subId)
    {
        MainRes mainRes=subService.deleteById(subId);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAllByMainId/{mainId}")
    public ResponseEntity<List<SubMasterRes>> getAllByMainId(@PathVariable("mainId") String mainId)
    {
        List<SubMasterRes> subMasterResList=subService.getAllByMainId(mainId);
        return new ResponseEntity<>(subMasterResList, HttpStatus.OK);
    }




}
