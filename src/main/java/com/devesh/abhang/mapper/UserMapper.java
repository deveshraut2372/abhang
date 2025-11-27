package com.devesh.abhang.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper Instance= Mappers.getMapper(UserMapper.class);


//    User maptoUser(UserReq userReq);

//    UserRes maptoUserRes(User user);



}
