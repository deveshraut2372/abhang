package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.UserReq;
import com.devesh.abhang.dto.Res.MainRes;


public interface UserService {

    public MainRes createUser(UserReq userReq);
}
