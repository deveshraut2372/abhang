package com.devesh.abhang.dto.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleReq {

    private String roleId;

    private String role;

    private String status;

    private LocalDate createDate;

}
