package com.devesh.abhang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
@Builder
public class User {

    @Id
    private String userId;

    private String firstName;

    private String lastName;

    private String profile;

    private String email;

    private String phone;

    private String password;

    private Role role;

    private String status;

    @CreatedDate
    private LocalDate createdDate;

    private LocalDate updatedDate;

    private String otp;


}
