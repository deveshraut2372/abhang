package com.devesh.abhang.dto.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {

    private String userName;

    private String password;

}
