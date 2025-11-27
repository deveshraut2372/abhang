package com.devesh.abhang.dto.Res;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentsMasterRes {

        private String commentId;

    private String comment;

    private String status;

    private LocalDate createdDate;

    private String subId;

    private String userId;



}
