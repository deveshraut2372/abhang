package com.devesh.abhang.dto.Res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    private String jwt;
    private String userId;
}
