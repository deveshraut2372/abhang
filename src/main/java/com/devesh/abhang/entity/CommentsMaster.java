package com.devesh.abhang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comments")
public class CommentsMaster {

    @Id
    private String commentId;

    private String comment;

    private String status;

    private LocalDate createdDate;

    private String subId;

    private String userId;


}
