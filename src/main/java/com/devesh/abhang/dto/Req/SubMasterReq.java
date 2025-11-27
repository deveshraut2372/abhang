package com.devesh.abhang.dto.Req;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubMasterReq{

    private String subId;

    private String name;

    private String status;

    private String content;

    private LocalDate createdDate;

    private String mainId;
}
