package com.devesh.abhang.controller;

import com.devesh.abhang.dto.Req.MainMasterReq;
import com.devesh.abhang.dto.Res.MainMasterRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Main")
public class MainController {

    @Autowired
    private MainService mainService;


    @PostMapping
    public ResponseEntity<MainRes> createMain(@RequestBody MainMasterReq mainMasterReq)
    {
        MainRes mainRes=mainService.createMain(mainMasterReq);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    public ResponseEntity<MainRes> updateMain(@RequestBody MainMasterReq mainMasterReq)
    {
        MainRes mainRes=mainService.createMain(mainMasterReq);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<MainMasterRes>> getAllMains()
    {
        List<MainMasterRes> mainMasterResList=mainService.getAllMains();
            return new ResponseEntity<>(mainMasterResList, HttpStatus.OK);
    }


    @GetMapping("/getByStatus/{status}")
    public ResponseEntity<List<MainMasterRes>> getAllMainsByStatus(@PathVariable("status") String status)
    {
        List<MainMasterRes> mainMasterResList=mainService.getAllMainsByStatus(status);
        return new ResponseEntity<>(mainMasterResList, HttpStatus.OK);
    }


    @GetMapping("/getById/{mainId}")
    public ResponseEntity<MainMasterRes> getById(@PathVariable("mainId") String mainId)
    {
        MainMasterRes mainMasterRes=mainService.getById(mainId);
        return new ResponseEntity<>(mainMasterRes, HttpStatus.OK);
    }

    @GetMapping("deleteById/{mainId}")
    public ResponseEntity<MainRes> deleteById(@PathVariable("mainId") String mainId)
    {
        MainRes mainRes=mainService.deleteById(mainId);
        if (mainRes.getFlag())
        {
            return new ResponseEntity<>(mainRes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
