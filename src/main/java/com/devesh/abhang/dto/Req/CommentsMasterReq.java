package com.devesh.abhang.dto.Req;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentsMasterReq {

    private String commentId;

    private String comment;

    private String status;

    private LocalDate createdDate;

    private String subId;

    private String userId;


}
