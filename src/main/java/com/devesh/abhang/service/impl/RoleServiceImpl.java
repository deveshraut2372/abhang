package com.devesh.abhang.service.impl;


import com.devesh.abhang.dto.Req.RoleReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.dto.Res.RoleRes;
import com.devesh.abhang.entity.Role;
import com.devesh.abhang.mapper.RoleMapper;
import com.devesh.abhang.repository.RoleRepository;
import com.devesh.abhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService
{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public MainRes createRole(RoleReq roleReq) {


        try
        {
            Role role=new Role();
            role=RoleMapper.Instance.RoleReqtoRole(roleReq);
            role.setStatus("Active");
            role.setCreateDate(LocalDate.now());

            System.out.println("  role ="+role.toString());
            Role role1=roleRepository.save(role);
            return new MainRes(true,"true","SUCCESS", LocalDateTime.now());
        }catch (Exception e){
            e.printStackTrace();
            return new MainRes(false,"false","INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }
    }

    @Override
    public List<RoleRes> getRoles() {

        List<Role> roles=roleRepository.findAll();
        System.out.println(roles.toString());
        return roles.stream().map(RoleMapper.Instance::roletoRoleRes).collect(Collectors.toList());
    }

    @Override
    public RoleRes getRoleById(String roleId) {
        Role role1=new Role();
        Optional<Role> role=roleRepository.findById(roleId);
        if(role.isPresent())
        {
            role1=role.get();
            return RoleMapper.Instance.roletoRoleRes(role1);
        }else {
            return RoleMapper.Instance.roletoRoleRes(role1);
        }
    }


}
