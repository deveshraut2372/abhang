package com.devesh.abhang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "role")
public class Role {
    @Id
    private String roleId;

    private String role;

    private String status;

    @CreatedDate
    private LocalDate createDate;
}
