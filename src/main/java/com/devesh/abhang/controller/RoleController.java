package com.devesh.abhang.controller;

import com.devesh.abhang.dto.Req.RoleReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.RoleRes;
import com.devesh.abhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<MainRes> createRole(@RequestBody RoleReq roleReq)
    {
        MainRes mainRes=roleService.createRole(roleReq);
        return new ResponseEntity<>(mainRes, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleRes>> getRoles()
    {
        List<RoleRes> roleResList=roleService.getRoles();
        return new ResponseEntity<>(roleResList, HttpStatus.OK);
    }


    @GetMapping("/getById/{roleId}")
    public ResponseEntity<RoleRes> getRoleById(@PathVariable("roleId") String roleId)
    {
        RoleRes roleRes=roleService.getRoleById(roleId);
        return new ResponseEntity<>(roleRes, HttpStatus.OK);
    }
}
