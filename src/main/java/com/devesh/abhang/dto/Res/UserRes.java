package com.devesh.abhang.dto.Res;


import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {

    private String userId;

    private String firstName;

    private String lastName;

    private String profile;

    private String email;

    private String phone;

    private String password;

//    private Role role;

    private String role;

    private String status;

    private LocalDate createdDate;

    private LocalDate updatedDate;
}
