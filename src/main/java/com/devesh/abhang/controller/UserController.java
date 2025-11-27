package com.devesh.abhang.controller;

import com.devesh.abhang.dto.Req.UserReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<MainRes> createUser(@RequestBody UserReq userReq)
    {
        MainRes mainRes=userService.createUser(userReq);
        if(mainRes.getFlag()) {
            return new ResponseEntity<>(mainRes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mainRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
