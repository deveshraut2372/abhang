package com.devesh.abhang.dto.Res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRes {

    private String roleId;

    private String role;

    private String status;

    private String createDate;
}
