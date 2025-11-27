package com.devesh.abhang.mapper;

import com.devesh.abhang.dto.Req.RoleReq;
import com.devesh.abhang.dto.Res.RoleRes;
import com.devesh.abhang.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper Instance= Mappers.getMapper(RoleMapper.class);

    Role RoleReqtoRole(RoleReq roleReq);

    RoleRes roletoRoleRes(Role role);


}
