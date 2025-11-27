package com.devesh.abhang.service;

import com.devesh.abhang.dto.Req.RoleReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.RoleRes;

import java.util.List;

public interface RoleService {


    MainRes createRole(RoleReq roleReq);

    List<RoleRes> getRoles();

    RoleRes getRoleById(String roleId);
}
